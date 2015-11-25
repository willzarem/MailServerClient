/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailserver.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.mailserver.handlers.ManejadorNewServer;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaNewServer extends JFrame implements ActionListener{

    private JPanel panelTittle, panelTxtBox, panelButton;
    private JLabel lblIp, lblDomain, lblTittle;
    private JTextField txtIp, txtDomain;
    private JButton btnBack, btnDone;
    
    ManejadorNewServer manejadorNewServer = ManejadorNewServer.getInstancia();
    
    public VentanaNewServer(){
        panelTittle = new JPanel();
        panelTxtBox = new JPanel();
        panelButton = new JPanel();
        btnBack = new JButton("Back");
        btnDone = new JButton("Done");
        lblTittle = new JLabel("NEW SERVER");
        lblIp = new JLabel("IP: ");
        lblDomain = new JLabel("Domain: ");
        txtIp = new JTextField(10);
        txtDomain = new JTextField(10);
        
        panelTittle.add(lblTittle);
        lblTittle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panelTxtBox.add(lblIp);
        panelTxtBox.add(txtIp);
        panelTxtBox.add(lblDomain);
        panelTxtBox.add(txtDomain);
        
        panelButton.add(btnBack);
        panelButton.add(btnDone);
        btnBack.addActionListener(this);
        btnDone.addActionListener(this);
        
        setLayout(new GridLayout(3, 1));
        add(panelTittle);
        add(panelTxtBox);
        add(panelButton);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            if(ae.getSource() == btnBack){
                VentanaWelcome ventanaWelcome = new VentanaWelcome();
                setVisible(false);
                ventanaWelcome.setVisible(true);
                ventanaWelcome.setSize(250, 250);
            } else if(ae.getSource() == btnDone){
                manejadorNewServer.obtenerDatos(txtIp.getText(), txtDomain.getText());
                vaciarTextBox(txtIp);
                vaciarTextBox(txtDomain);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void vaciarTextBox(JTextField txtBox){
        txtBox.setText(null);
    }
    
}
