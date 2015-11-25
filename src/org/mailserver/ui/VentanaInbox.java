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
 * @author omartinez
 */
public class VentanaInbox extends JFrame implements ActionListener{
    private JMenuBar mb;
    private JMenu menuArchivo, menuEditar;
    private JMenuItem sendEmail, viewEmails, addContact, listContacts;
    private JPanel panelTable, panelButton;
    private JButton back;
    private JTable tableInbox;
    private JLabel lblInbox;
    
    public VentanaInbox(){
        mb = new JMenuBar();
        setJMenuBar(mb);
        menuArchivo = new JMenu("Archivo");
        mb.add(menuArchivo);
        menuEditar = new JMenu("Editar");
        mb.add(menuEditar);
        
        panelTable = new JPanel();
        panelButton = new JPanel();
        lblInbox = new JLabel("INBOX");
        lblInbox.setFont(new java.awt.Font("Comic Sans", 0, 20));
        tableInbox = new JTable(2, 3);
        back = new JButton("Back");
        
        panelTable.add(lblInbox);
        panelTable.add(tableInbox);
        
        panelButton.add(back);
        back.addActionListener(this);
        
        
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
        
        setLayout(new GridLayout(2, 1));
        add(panelTable);
        add(panelButton);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            VentanaLogin viewLogin = new VentanaLogin();
            setVisible(false);
            viewLogin.setVisible(true);
            viewLogin.setSize(250, 250);
        } else if(e.getSource() == sendEmail){
            setVisible(false);
            VentanaSendMessage sendMessage = new VentanaSendMessage();
            sendMessage.setVisible(true);
            sendMessage.setSize(350, 400);
        } else if(e.getSource() == viewEmails){
            System.out.println("presiono Ver emails");
        } else if(e.getSource() == addContact){
            setVisible(false);
            VentanaNewContact newContact = new VentanaNewContact();
            newContact.setVisible(true);
            newContact.setSize(250 , 250);
        } else if(e.getSource() == listContacts){
            VentanaListContacts ventanaListContacts = new VentanaListContacts();
            setVisible(false);
            ventanaListContacts.setVisible(true);
            ventanaListContacts.setSize(250, 250);
        }
    }
}
