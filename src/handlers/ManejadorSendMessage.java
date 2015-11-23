/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import javax.swing.JOptionPane;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorSendMessage {
    
    public static final ManejadorSendMessage INSTANCE = new ManejadorSendMessage();
    
    public static ManejadorSendMessage getINSTANCE(){
        return INSTANCE;
    }
    
    public void sendMessage(String recipient, String subject, String body){
        System.out.println("MAIL TO " + recipient);
        System.out.println("MAIL SUBJECT " + subject);
        System.out.println("MAIL BODY " + body);
        System.out.println("END SEND MAIL");
        JOptionPane.showMessageDialog(null, "Message Sent", "SENT", JOptionPane.INFORMATION_MESSAGE);
    }
}
