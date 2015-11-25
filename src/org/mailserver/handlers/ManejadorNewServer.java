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
public class ManejadorNewServer {
    
    public static ManejadorNewServer instancia;
    
    public static ManejadorNewServer getInstancia(){
        if(instancia == null){
            instancia = new ManejadorNewServer();
        }
        return instancia;
    }
    
    
    public void obtenerDatos(String ip, String domain) throws Exception {
        
        // Validate values
        Scanner domainScan = new Scanner(domain);
        Scanner ipScan = new Scanner(ip);
        if (ip.equals("") 
                || domain.equals("") 
                || !domainScan.hasNext("[a-z]+\\.[a-z]{2,5}") 
                || !ipScan.hasNext("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$")){
            throw new Exception("Server not valid");
        }
        
        // Already added domain
        if (MailServerClient.serverDomainExists(domain)){
            throw new Exception("Domain already registered.");
        }        
        
        // Add the new domain
        MailServerClient.newServer(domain, ip);
        
        System.out.println("Ip: " + ip);
        System.out.println("Domain: " + domain);
    }
}
