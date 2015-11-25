/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

import java.util.Scanner;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorLogin {
    
    //Esto es singleton
    private static ManejadorLogin instancia = new ManejadorLogin();

    public static ManejadorLogin getInstancia() {
        if(instancia == null){
            instancia = new ManejadorLogin();
        }
        return instancia;
    }
    
    public boolean UserAuthentication(String usrEmail, String pass){
        if((usrEmail.equals("oscar@domain.com")) && (pass.equals("hola"))){
            return true;
        } else {
            return false;
        }
    }
    
    public void separateMail(String email, String password){
        Scanner sc = new Scanner(email);
        sc.useDelimiter("@");
        String user = sc.next();
        String domain = sc.next();
        
        obtenerDatos(user, domain, password);
    }
    
    public void obtenerDatos(String name, String domain, String password) {
        
        
        
        System.out.println("name: " + name);
        System.out.println("domain: " + domain);
        System.out.println("password: " + password);
    }
}
