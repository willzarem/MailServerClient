package handlers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Oscar Martinez
 */
public class ManejadorLogin {
    
    //Esto es singleton
    private static final ManejadorLogin INSTANCE = new ManejadorLogin();
    private Socket serverSocket;
    private static String SEVER_IP, LOCAL_IP;
    

    public static ManejadorLogin getINSTANCE() throws UnknownHostException, IOException, NotReachableException {
        try {
            SEVER_IP = "192.168.0.1";
            LOCAL_IP = InetAddress.getLocalHost().getHostAddress();
            
            System.out.println("Server: " + SEVER_IP);
            System.out.println("Local: " + LOCAL_IP);
            if (!InetAddress.getByName(SEVER_IP).isReachable(2000)) {
                throw new NotReachableException(SEVER_IP);
            }
        } catch(UnknownHostException e) {
            System.out.println("LOGIN ERROR 404 - Host Not Found");
            System.out.println("UnknownHostException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("LOGIN ERROR 408 - Connection Time Out");
            System.out.println("IOException: " + e.getMessage());
        } catch(NotReachableException e) {
            System.out.println("LOGIN ERROR 404 - Server Not Reachable ");
        }
        
        return INSTANCE;
    }
    
    public boolean UserAuthentication(String usrName, String pass){
        
        if((usrName.equals("oscar")) && (pass.equals("hola"))){
            return true;
        } else {
            return false;
        }
    }
    
    public String obtenerDatos(String name, String password) {
        String log = "LOGIN " + name + " " + password;
        return log;
    }
        
}
