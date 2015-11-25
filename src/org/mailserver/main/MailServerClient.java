package org.mailserver.main;

import java.util.Hashtable;
import org.mailserver.ui.VentanaWelcome;

/**
 *
 * @author Oscar Martinez
 */
public class MailServerClient {

    private static Hashtable<String, String> serversList  = new Hashtable<>();
    /**
     * @param args the command line arguments
     */
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
    
    public static void main(String[] args) {
        final VentanaWelcome miVentana = new VentanaWelcome();
        
        serversList.put("saniin.com", "127.0.0.1");
        serversList.put("galileo.edu", "127.0.0.1");
        serversList.put("hotmail.com", "127.0.0.1");
        

        miVentana.setVisible(true);
        miVentana.setSize(250 , 250);
    }
    
}
