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
    private static ManejadorLogin instancia;

    public static ManejadorLogin getInstancia() {
        if(instancia == null){
            instancia = new ManejadorLogin();
        }
        return instancia;
    }
    
    public boolean UserAuthentication(String usrName, String pass){
        Scanner scan = new Scanner(usrName);
        scan.useDelimiter("@");
        String user = scan.next();
        String domain = scan.next();
        
        System.out.println(user);
        System.out.println(domain);
        return usrName.equals("oscar") && pass.equals("hola");
    }
    /*public void btnLogin() {
        System.out.println("Hola!!!");
    }*/
    
    public String obtenerDatos(String name, String password) {
        String log = "LOGIN " + name + " " + password;
        System.out.println(log);
        return log;
    }
}
