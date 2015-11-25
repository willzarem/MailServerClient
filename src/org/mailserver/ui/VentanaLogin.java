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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.mailserver.handlers.ManejadorLogin;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaLogin extends JFrame implements ActionListener{
    private JButton btnLogin, btnBack;
    private JLabel lblUsrName;
    private JLabel lblPass;
    private JLabel lblLOGIN;
    private JTextField txtUsrName;
    private JPasswordField txtPass;
    private JPanel panelTittle, panelUsareName, panelPassword, panelButton;
    
    ManejadorLogin manejadorLogin = ManejadorLogin.getInstancia();
    
    public VentanaLogin(){
        panelTittle = new JPanel();
        panelUsareName = new JPanel();
        panelPassword = new JPanel();
        panelButton = new JPanel();
        btnLogin = new JButton("Login");
        btnBack = new JButton("Back");
        lblUsrName = new JLabel("Email: ");
        lblPass = new JLabel("Password: ");
        lblLOGIN = new JLabel("LOGIN");
        txtUsrName = new JTextField(15);
        txtPass = new JPasswordField(13);

        //Panel de titulo LOGIN
        panelTittle.add(lblLOGIN);
        lblLOGIN.setFont(new java.awt.Font("Comic Sans", 0, 36));//aqui cambio el tipo y tamaño de la letra

        //Panel de primer cuadro de dialogo y primer label
        panelUsareName.add(lblUsrName);
        panelUsareName.add(txtUsrName);

        //panel de segundo cuadro de dialogo y segundo label
        panelPassword.add(lblPass);
        panelPassword.add(txtPass);

        //panel de boton 
        panelButton.add(btnBack);
        panelButton.add(btnLogin);
        btnBack.addActionListener(this);
        btnLogin.addActionListener(this);

        //aqui se estan agregando todos los paneles a la ventana.
        setLayout(new GridLayout(4,1));
        add(panelTittle);
        add(panelUsareName);
        add(panelPassword);
        add(panelButton);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if(ae.getSource() == btnLogin){
                boolean auth = manejadorLogin.obtenerDatos(txtUsrName.getText(), txtPass.getText());
                if(!auth){
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    setVisible(false);
                    VentanaInbox inbox = new VentanaInbox();

                    inbox.setVisible(true);
                    inbox.setSize(250, 250);
                }
            } else if(ae.getSource() == btnBack){
                VentanaWelcome ventanaWelcome = new VentanaWelcome();
                setVisible(false);
                ventanaWelcome.setVisible(true);
                ventanaWelcome.setSize(250, 250);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
