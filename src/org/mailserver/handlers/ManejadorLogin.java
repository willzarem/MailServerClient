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
import java.util.Date;
import java.util.Scanner;
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
        
        loginSocket = new Socket(MailServerClient.getServerAddress(domain), 9090);
        out = new PrintWriter(loginSocket.getOutputStream(), true);
        incoming = new BufferedReader(new InputStreamReader(loginSocket.getInputStream()));
        
        out.println("LOGIN " + name + " " + password);        
        response = incoming.readLine();
        
        System.out.println(name + "@" + domain);
        System.out.println("password: " + password);
        System.out.println("Response: " + response);
        
        return UserAuthentication(response);
    }
}
