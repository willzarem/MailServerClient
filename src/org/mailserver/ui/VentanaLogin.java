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
import org.mailserver.handlers.ServerDomainNotAdded;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaLogin extends JFrame{
    private JButton btnLogin;
    private JLabel lblUsrName;
    private JLabel lblDomain;
    private JLabel lblPass;
    private JLabel lblLOGIN;
    private JTextField txtUsrName;
    private JPasswordField txtPass;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    
    ManejadorLogin manejadorLogin = ManejadorLogin.getInstancia();
    
    public VentanaLogin(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        btnLogin = new JButton("Login");
        lblUsrName = new JLabel("Email: ");
        lblDomain = new JLabel("@server.com");
        lblPass = new JLabel("Password: ");
        lblLOGIN = new JLabel("LOGIN");
        txtUsrName = new JTextField(9);
        txtPass = new JPasswordField(10);

        //Panel de titulo LOGIN
        panel1.add(lblLOGIN);
        lblLOGIN.setFont(new java.awt.Font("Comic Sans", 0, 36));//aqui cambio el tipo y tamaño de la letra

        //Panel de primer cuadro de dialogo y primer label
        panel2.add(lblUsrName);
        panel2.add(txtUsrName);
        panel2.add(lblDomain);

        //panel de segundo cuadro de dialogo y segundo label
        panel3.add(lblPass);
        panel3.add(txtPass);

        //panel de boton 
        panel4.add(btnLogin);

        //aqui se estan agregando todos los paneles a la ventana.
        setLayout(new GridLayout(4,1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnLogin){
            boolean auth = false ;
            try {
                manejadorLogin.UserAuthentication(txtUsrName.getText(), txtPass.getText());
            } catch (ServerDomainNotAdded ex) {
                JOptionPane.showMessageDialog(null, "Server unknown: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect Credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            System.out.println(manejadorLogin.obtenerDatos(txtUsrName.getText(), txtPass.getText()));
            if(!auth){
                JOptionPane.showMessageDialog(null, "Incorrect Credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                setVisible(false);
                VentanaMenu menu = new VentanaMenu();
                
                menu.setVisible(true);
                menu.setSize(250, 250);
            }
        } 

        }});
    }
}
