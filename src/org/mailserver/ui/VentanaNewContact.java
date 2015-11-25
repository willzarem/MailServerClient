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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.mailserver.handlers.ManejadorNewContact;

/**
 *
 * @author omartinez
 */
public class VentanaNewContact extends JFrame implements ActionListener{
    private JPanel panelTittle, panelContact, panelButton;
    private JLabel lblTitle, lblContEmail;
    private JTextField txtContEmail;
    private JButton btnAddContact, btnBack;
    private JMenuBar mb;
    private JMenu menuArchivo, menuEditar;
    private JMenuItem sendEmail, viewEmails, addContact, listContacts;
    ManejadorNewContact manejadorNewContact = ManejadorNewContact.getInstancia();
    
    public VentanaNewContact(){
        panelTittle = new JPanel();
        panelContact = new JPanel();
        panelButton = new JPanel();
        lblContEmail = new JLabel("Contact Email: ");
        lblTitle = new JLabel("ADD NEW CONTACT");
        txtContEmail = new JTextField(10);
        btnAddContact = new JButton("Add Contact");
        btnBack = new JButton("Back");
        
        mb = new JMenuBar();
        setJMenuBar(mb);
        menuArchivo = new JMenu("Archivo");
        mb.add(menuArchivo);
        menuEditar = new JMenu("Editar");
        mb.add(menuEditar);
        
        sendEmail = new JMenuItem("New Email");
        sendEmail.addActionListener(this);
        menuArchivo.add(sendEmail);
        
        viewEmails = new JMenuItem("Inbox");
        viewEmails.addActionListener(this);
        menuArchivo.add(viewEmails);
        
        addContact = new JMenuItem("Add New Conctact");
        addContact.addActionListener(this);
        menuEditar.add(addContact);
        
        listContacts = new JMenuItem("View Contacts");
        listContacts.addActionListener(this);
        menuEditar.add(listContacts);
        
        panelTittle.add(lblTitle);
        lblTitle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panelContact.add(lblContEmail);
        panelContact.add(txtContEmail);
        
        panelButton.add(btnBack);
        panelButton.add(btnAddContact);
        
        setLayout(new GridLayout(3, 1));
        add(panelTittle);
        add(panelContact);
        add(panelButton);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnAddContact.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddContact){
            System.out.println(manejadorNewContact.getInstancia().obtenerDatos(txtContEmail.getText()));
            setVisible(false);
        }else if(e.getSource() == sendEmail){
            setVisible(false);
            VentanaSendMessage sendMessage = new VentanaSendMessage();
            sendMessage.setVisible(true);
            sendMessage.setSize(250, 350);
        } else if(e.getSource() == viewEmails){
            System.out.println("presiono Ver emails");
        } else if(e.getSource() == addContact){
            setVisible(false);
            VentanaNewContact newContact = new VentanaNewContact();
            newContact.setVisible(true);
            newContact.setSize(250 , 250);
        } else if(e.getSource() == listContacts){
            System.out.println("presiono list contacts");
        } else if(e.getSource() == btnBack){
            VentanaInbox inbox = new VentanaInbox();
            setVisible(false);
            inbox.setVisible(true);
            inbox.setSize(250, 250);
        }
    }
}
