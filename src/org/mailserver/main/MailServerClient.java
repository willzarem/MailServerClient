package org.mailserver.main;

import org.mailserver.ui.VentanaLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Oscar Martinez
 */
public class MailServerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final VentanaLogin miVentana = new VentanaLogin();

        miVentana.setVisible(true);
        miVentana.setSize(250 , 250);
    }
    
}
