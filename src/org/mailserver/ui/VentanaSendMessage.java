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
public class VentanaSendMessage extends JFrame implements ActionListener{
    JPanel panelTittle, panelTo, panelSubject, panelMessage, panelButton;
    JLabel lblTo, lblSubject, lblMessage;
    JTextField txtEmail;
    JTextField txtSubject;
    JTextArea txtMessage;
    JLabel lblTittle;
    JButton btnSend, btnBack;
    ManejadorSendMessage manejadorSendMessage = ManejadorSendMessage.getInstancia();
    public VentanaSendMessage(){
        panelTittle = new JPanel();
        panelTo = new JPanel();
        panelSubject = new JPanel();
        panelMessage = new JPanel();
        panelButton = new JPanel();
        lblTo = new JLabel("To: ");
        lblSubject = new JLabel("Subject: ");
        lblMessage = new JLabel("Message:");
        txtEmail = new JTextField(10);
        txtSubject = new JTextField(10);
        txtMessage = new JTextArea(1, 1);
        lblTittle = new JLabel("NEW EMAIL");
        btnSend = new JButton("Send");
        btnBack = new JButton("Back");
        
        panelTittle.add(lblTittle);
        lblTittle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panelTo.add(lblTo);
        panelTo.add(txtEmail);
        
        panelSubject.add(lblSubject);
        panelSubject.add(txtSubject);
        
        panelMessage.setLayout(new GridLayout(2, 1));
        panelMessage.add(lblMessage);
        panelMessage.add(txtMessage);
        
        panelButton.add(btnBack);
        panelButton.add(btnSend);
        btnBack.addActionListener(this);
        btnSend.addActionListener(this);
        
        setLayout(new GridLayout(5, 1));
        add(panelTittle);
        add(panelTo);
        add(panelSubject);
        add(panelMessage);
        add(panelButton);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            VentanaInbox ventanaInbox = new VentanaInbox();
            setVisible(false);
            ventanaInbox.setVisible(true);
            ventanaInbox.setSize(250, 350);
        } else if(e.getSource() == btnSend){
            manejadorSendMessage.sendMessage(txtEmail.getText(), txtSubject.getText(), txtMessage.getText());
        }
    }
}
