package org.mailserver.main;

import java.util.Hashtable;
import java.util.Scanner;
import org.mailserver.ui.VentanaWelcome;

/**
 *
 * @author Oscar Martinez
 */
public class MailServerClient {

    private static Hashtable<String, String> serversList  = new Hashtable<>();
    private static Hashtable<String, String> contactsList  = new Hashtable<>();
    
    public static void newServer(String domain, String ip) {
        serversList.put(domain, ip);
        
        System.out.println(serversList.toString());
    }
    
    public static boolean serverDomainExists(String domain) { 
        return serversList.containsKey(domain);
    }
    
    public static String getServerAddress(String domain) { 
        return serversList.get(domain);
    }
    
    // Contacts handling
    
    public static void newContact(String userName, String email) {
        contactsList.put(userName, email);
        
        System.out.println(contactsList.toString());
    }
    
    public static boolean contactExists(String userName) { 
        return contactsList.containsKey(userName);
    }
    
    public static void storeContacts(String contactsResponse) { 
        System.out.println("contactsResponse: " + contactsResponse);
        
        Scanner scResponse = new Scanner(contactsResponse);
        Scanner scParse;
        String username, email;
        scResponse.useDelimiter("\\|");
        while(scResponse.hasNext()) {
            scParse = new Scanner(scResponse.next().trim());
            scParse.useDelimiter(" ");
            if (scParse.next().equals("OK") && scParse.next().equals("CLIST")) {
                scParse = new Scanner(scParse.next().trim());
                scParse.useDelimiter("@");
                username = scParse.next();
                email = username + "@" + scParse.next();
                
                // if is last received command
                if (email.trim().substring(email.length() - 1).equals("*")) {
                    email = email.substring(0, email.length()-1);
                }
                
                // Store all contacts
                contactsList.put(username, email);
            }
        }
                
        System.out.println(contactsList);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final VentanaWelcome miVentana = new VentanaWelcome();
        
        
        // Default servers
        serversList.put("saniin.com", "127.0.0.1");
        serversList.put("galileo.edu", "127.0.0.1");
        serversList.put("hotmail.com", "127.0.0.1");
        

        miVentana.setVisible(true);
        miVentana.setSize(250 , 250);
    }
    
}
