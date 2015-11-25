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
public class VentanaWelcome extends JFrame implements ActionListener{
    
    JLabel lblWelcome;
    JButton btnNewServer, btnLogin;
    JPanel panelLabel, panelButton;
    
    public VentanaWelcome(){
        panelLabel = new JPanel();
        panelButton = new JPanel();
        lblWelcome = new JLabel("WELCOME");
        btnNewServer = new JButton("New Server");
        btnLogin = new JButton("Login");
        
        panelLabel.add(lblWelcome);
        lblWelcome.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panelButton.add(btnNewServer);
        panelButton.add(btnLogin);
        btnNewServer.addActionListener(this);
        btnLogin.addActionListener(this);
        
        setLayout(new GridLayout(2, 1));
        add(panelLabel);
        add(panelButton);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnNewServer){
            VentanaNewServer ventanaNewServer = new VentanaNewServer();
            setVisible(false);
            ventanaNewServer.setVisible(true);
            ventanaNewServer.setSize(400, 250);
        } else if(ae.getSource() == btnLogin){
            setVisible(false);
            VentanaLogin ventanaLogin = new VentanaLogin();
            ventanaLogin.setVisible(true);
            ventanaLogin.setSize(250, 250);
        }
    }
    
}
