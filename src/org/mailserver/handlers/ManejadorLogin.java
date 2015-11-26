/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.mailserver.main.MailServerClient;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorLogin {
    
    private Socket loginSocket;
    
    //Esto es singleton
    private static ManejadorLogin instancia = new ManejadorLogin();

    public static ManejadorLogin getInstancia() {
        if(instancia == null){
            instancia = new ManejadorLogin();
        }
        return instancia;
    }
    
    private boolean UserAuthentication(String srvResponse){
        return srvResponse.equals("LOGIN OK");
    }
    
    public boolean obtenerDatos(String email, String password) throws Exception {
        Scanner sc = new Scanner(email);
        sc.useDelimiter("@");
        String name = sc.next();
        String domain = sc.next();
        PrintWriter out;
        BufferedReader incoming;
        String response;
        
        if (!MailServerClient.serverDomainExists(domain)){
            throw new Exception("Domain not registered");
        }
        
        loginSocket = new Socket(MailServerClient.getServerAddress(domain), 1400);
        out = new PrintWriter(loginSocket.getOutputStream(), true);
        incoming = new BufferedReader(new InputStreamReader(loginSocket.getInputStream()));
        
        System.out.println("LOGIN " + name + " " + password);
        out.println("LOGIN " + name + " " + password);
        response = incoming.readLine();
        
        if (!Pattern.compile("OK LOGIN").matcher(response).matches()) {
            throw new Exception(response);
        }
        
        System.out.println("CLIST " + name);
        out.println("CLIST " + name);
        response = incoming.readLine();
        System.out.println(response);
        
        if (!Pattern.compile("OK CLIST .*").matcher(response).matches()) {
            throw new Exception(response);
        } 
        
        MailServerClient.storeContacts(response);
        
        System.out.println("CLIST " + name);
        out.println("CLIST " + name);
        response = incoming.readLine();
        
        if (!Pattern.compile("OK CLIST .*").matcher(response).matches()) {
            throw new Exception(response);
        } 
        
        
        return UserAuthentication(response);
    }
}
