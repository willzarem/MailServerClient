/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaMenu extends JFrame{
    JPanel panel1;
    JPanel panel2;
    JButton btnAddContact;
    JButton btnSendEmail;
    JLabel lblTittle;
    
    public VentanaMenu(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        btnAddContact = new JButton("Add New Contact");
        btnSendEmail = new JButton("Send Email");
        lblTittle = new JLabel("MENU");
        
        panel1.add(lblTittle);
        lblTittle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panel2.add(btnAddContact);
        panel2.add(btnSendEmail);
        
        setLayout(new GridLayout(2,1));
        add(panel1);
        add(panel2);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ManejadorMenu manejador = new ManejadorMenu();
        
        btnAddContact.addActionListener(manejador);
        btnSendEmail.addActionListener(manejador);
    }
    
    public class ManejadorMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == btnAddContact){
                setVisible(false);
                VentanaNewContact newContact = new VentanaNewContact();
                newContact.setVisible(true);
                newContact.setSize(250 , 250);
            } else if(ae.getSource() == btnSendEmail){
                setVisible(false);
                VentanaSendMessage sendMessage = new VentanaSendMessage();
                sendMessage.setVisible(true);
                sendMessage.setSize(250, 350);
                System.out.println("SEND MAIL");
            }
        }
    
    }
}
