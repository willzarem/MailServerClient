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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.mailserver.handlers.ManejadorSendMessage;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaSendMessage extends JFrame {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JLabel lblTo;
    JLabel lblSubject;
    JLabel lblMessage;
    JTextField txtEmail;
    JTextField txtSubject;
    JTextArea txtMessage;
    JLabel lblTittle;
    JButton btnSend;
    ManejadorSendMessage manejadorSendMessage = ManejadorSendMessage.getInstancia();
    public VentanaSendMessage(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        lblTo = new JLabel("To: ");
        lblSubject = new JLabel("Subject: ");
        lblMessage = new JLabel("Message:");
        txtEmail = new JTextField(10);
        txtSubject = new JTextField(10);
        txtMessage = new JTextArea(10, 20);
        lblTittle = new JLabel("NEW EMAIL");
        btnSend = new JButton("Send");
        
        panel1.add(lblTittle);
        lblTittle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panel2.add(lblTo);
        panel2.add(txtEmail);
        
        panel3.add(lblSubject);
        panel3.add(txtSubject);
        
        panel4.add(lblMessage);
        panel4.add(txtMessage);
        
        panel5.add(btnSend);
        
        setLayout(new GridLayout(5, 1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnSend.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent e){
        manejadorSendMessage.sendMessage(txtEmail.getText(), txtSubject.getText(), txtMessage.getText());
        } 

        });
    }
}
