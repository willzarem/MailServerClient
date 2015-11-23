/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author omartinez
 */
public class VentanaNewContact extends JFrame{
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel lblTitle;
    JLabel lblContEmail;
    JTextField txtContEmail;
    JButton btnAddContact;
    
    public VentanaNewContact(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        lblContEmail = new JLabel("Contact Email: ");
        lblTitle = new JLabel("ADD NEW CONTACT");
        txtContEmail = new JTextField(10);
        btnAddContact = new JButton("Add Contact");
        
        panel1.add(lblTitle);
        lblTitle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panel2.add(lblContEmail);
        panel2.add(txtContEmail);
        
        panel3.add(btnAddContact);
        
        setLayout(new GridLayout(3, 1));
        add(panel1);
        add(panel2);
        add(panel3);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ManejadorNewContact manejador = new ManejadorNewContact();
	btnAddContact.addActionListener(manejador);
    }
    
    public class ManejadorNewContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(handlers.ManejadorNewContact.getINSTANCE().obtenerDatos(txtContEmail.getText()));
            setVisible(false);
        }
    
    }
}
