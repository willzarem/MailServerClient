
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class DemoServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("DEMO SERVER");
        ServerSocket listener = new ServerSocket(1400);
        BufferedReader incoming;
        PrintWriter out;
        String response;
        Socket socket;
        try {
            
            socket = listener.accept();
            try {
                while (true) {
                    incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                    response = incoming.readLine();

                    System.out.println("in: " + response);

                    if (Pattern.compile("LOGIN [a-z]+ .*").matcher(response).matches()) {
                        out.println("OK LOGIN");
                    } else if (Pattern.compile("CLIST [a-z]+").matcher(response).matches()) {
                        out.println("OK CLIST contact1@server1 | " + "OK CLIST contact2@server2 | " + "OK CLIST contact3@server3 *");
                    } else if (Pattern.compile("GETNEWMAILS [a-z]+").matcher(response).matches()) {
                        out.println("OK GETNEWMAILS xxx@server1 \"Hola\" \"Hola, como estas? Nos vemos pronto\" | OK GETNEWMAILS yyy@server2 \"Cumple Sofia\" \"Hola a todos, el cumple de Sofia va a ser en su casa, el sabado a las 8, los veo ahi. \" *");
                    } else {
                        out.println("ERROR");
                    }
                }

            }catch(Exception e) {
                System.out.println("SERVER ERROR: " + e.getMessage());
            } finally {
                socket.close();
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            listener.close();
        }
    }
}
