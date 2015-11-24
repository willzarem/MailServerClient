/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

import java.util.Scanner;
import org.mailserver.main.MailServerClient;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorLogin {
    
    //Esto es singleton
    private static ManejadorLogin instancia;

    public static ManejadorLogin getInstancia() {
        if(instancia == null){
            instancia = new ManejadorLogin();
        }
        return instancia;
    }
    
    public boolean UserAuthentication(String usrName, String pass) throws ServerDomainNotAdded {
        Scanner scan = new Scanner(usrName);
        scan.useDelimiter("@");
        String user = scan.next();
        String domain = scan.next();
        String domainIp = getDomainIP(domain);

        System.out.println(user);
        System.out.println(domain);
        System.out.println(domainIp);
        return (usrName.equals("oscar")) && (pass.equals("hola"));
    }
    
    private String getDomainIP(String domainName) throws ServerDomainNotAdded {
        String domainIP = "";

        if (MailServerClient.SERVERS.containsKey(domainName)){
            domainIP =  MailServerClient.SERVERS.get(domainName);
        } else {
            throw new ServerDomainNotAdded();
        }
        
        return domainIP;
    }
    
    public String obtenerDatos(String name, String password) {
        String log = "LOGIN " + name + " " + password;
        return log;
    }
}
