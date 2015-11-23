/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

/**
 *
 * @author omartinez
 */
public class ManejadorNewContact {
    
    private static final ManejadorNewContact INSTANCE = new ManejadorNewContact();

    public static ManejadorNewContact getINSTANCE() {
        return INSTANCE;
    }
    
    public String obtenerDatos(String email) {
        String NewCont = "NEWCONT " + email;
        return NewCont;
    }
}
