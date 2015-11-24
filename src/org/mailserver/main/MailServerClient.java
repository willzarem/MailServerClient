package org.mailserver.main;

import java.util.Hashtable;
import org.mailserver.ui.VentanaLogin;

/**
 *
 * @author Oscar Martinez
 */
public class MailServerClient {
    
    public static Hashtable<String, String> SERVERS;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SERVERS = new Hashtable<>();
        
        SERVERS.put("saniin.com", "192.168.0.1");
        SERVERS.put("galileo.edu", "192.168.0.2");
        SERVERS.put("hotmail.com", "192.168.0.3");
        
        final VentanaLogin miVentana = new VentanaLogin();

        miVentana.setVisible(true);
        miVentana.setSize(250 , 250);
    }
    
}
