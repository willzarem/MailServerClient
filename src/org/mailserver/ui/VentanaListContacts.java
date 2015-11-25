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
import javax.swing.JTable;

/**
 *
 * @author Oscar Martinez
 */
public class VentanaListContacts extends JFrame implements ActionListener{
    
    private JMenuBar mb;
    private JMenu menuArchivo, menuEditar;
    private JMenuItem sendEmail, viewEmails, addContact, listContacts;
    private JTable tableContacts;
    private JPanel panelTittle, panelTable, panelButton;
    private JLabel lblTittle;
    private JButton btnBack;
    
    public VentanaListContacts() {
        
        panelTittle = new JPanel();
        panelTable = new JPanel();
        panelButton = new JPanel();
        
        btnBack = new JButton("Back");
        
        lblTittle = new JLabel("Contact List");
        
        tableContacts = new JTable(3, 2);
        
        panelTittle.add(lblTittle);
        lblTittle.setFont(new java.awt.Font("Comic Sans", 0, 20));
        
        panelTable.add(tableContacts);
        
        panelButton.add(btnBack);
        btnBack.addActionListener(this);
        
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
        
        setLayout(new GridLayout(3, 1));
        add(panelTittle);
        add(panelTable);
        add(panelButton);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== btnBack){
            VentanaInbox ventanaInbox = new VentanaInbox();
            setVisible(false);
            ventanaInbox.setVisible(true);
            ventanaInbox.setSize(250, 250);
        } else if(ae.getSource() == sendEmail){
            setVisible(false);
            VentanaSendMessage sendMessage = new VentanaSendMessage();
            sendMessage.setVisible(true);
            sendMessage.setSize(250, 350);
        } else if(ae.getSource() == viewEmails){
            System.out.println("presiono Ver emails");
        } else if(ae.getSource() == addContact){
            setVisible(false);
            VentanaNewContact newContact = new VentanaNewContact();
            newContact.setVisible(true);
            newContact.setSize(250 , 250);
        } else if(ae.getSource() == listContacts){
            System.out.println("presiono list contacts");
        }
    }
    
    
}
