/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.handlers;

import javax.swing.JOptionPane;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorSendMessage {
    
    public static ManejadorSendMessage instancia = new ManejadorSendMessage();
    
    public static ManejadorSendMessage getInstancia(){
        if(instancia == null){
            instancia = new ManejadorSendMessage();
        }
        return instancia;
    }
    
    public void sendMessage(String recipient, String subject, String body){
        System.out.println("destinatario: " + recipient);
        System.out.println("asunto:  " + subject);
        System.out.println("Mensaje: " + body);
        JOptionPane.showMessageDialog(null, "Message Sent", "SENT", JOptionPane.INFORMATION_MESSAGE);
    }
}
