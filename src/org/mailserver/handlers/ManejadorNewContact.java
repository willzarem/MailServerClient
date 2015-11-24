/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

/**
 *
 * @author omartinez
 */
public class ManejadorNewContact {
    
    private static ManejadorNewContact instancia = new ManejadorNewContact();

    public static ManejadorNewContact getInstancia() {
        if(instancia == null){
            instancia = new ManejadorNewContact();
        }
        return instancia;
    }
    
    public String obtenerDatos(String email) {
        String NewCont = "NEWCONT " + email;
        return NewCont;
    }
}
