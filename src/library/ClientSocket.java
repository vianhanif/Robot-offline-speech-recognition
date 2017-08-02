package library;

//import org.trypticon.megahal.engine.Ryuji;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Main class primarily for testing.
 *
 * @author Trejkaz
 */
public class ClientSocket {

    /**
     * Main method.
     *
     * @param args command-line arguments (ignored.)
     */
    
    public final String host = "localhost";
    public final String portNumber = "1500";    
    public Client client;
    public Socket echoSocket;
    public PrintWriter outPrint;
    public BufferedReader inPrint;

    public ClientSocket(){
        try {
            echoSocket = new Socket(host, Integer.parseInt(portNumber));
            outPrint    = new PrintWriter(echoSocket.getOutputStream(), true);
            inPrint     = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            client = new Client(outPrint, inPrint);      
        } catch (IOException e) {
            System.err.println("[Application] : failed to open socket");
        }
    }
    
    public Client getClient() {
        return client;
    }
    
    
    public void runMessage(String message) {
        try {
            System.out.println("[Application] : trying to send message \"" + message + "\"");
            client.WriteMessage(message);
        } catch (IOException e) {
            System.out.println("[Application] : failed to send message \"" + message + "\"");
        }
    }

}

//client.WriteMessage(command[1].replaceAll(" ", "\\."));