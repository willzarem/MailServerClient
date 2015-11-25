/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

import org.mailserver.ui.VentanaSendMessage;

/**
 *
 * @author omartinez
 */
public class ManejadorInbox {
    public void sendEmail(){
        VentanaSendMessage sendMessage = new VentanaSendMessage();
        sendMessage.setVisible(true);
        sendMessage.setSize(250, 350);
        System.out.println("SEND MAIL");
    }
}
