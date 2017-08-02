/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author anne
 */

import java.io.*;

public class Client {
    public final PrintWriter out;
    public final BufferedReader in;
    
    public Client(PrintWriter out, BufferedReader in){
        this.out = out;
        this.in = in;
    }
    
    public String getMessage() throws IOException{
        /*
        if ((host.equals(null)) && (portNum.equals(null))) {
            System.err.println( "Usage: java EchoClient <host name> <port number>" );
            System.exit(1);
        }
        */                        
        return in.readLine();
   }
    
    
    public void WriteMessage(String message) throws IOException{
        /*
        if ((host.equals(null)) && (portNum.equals(null))) {
            System.err.println( "Usage: java EchoClient <host name> <port number>" );
            System.exit(1);
        }
        */
                out.println(message);
                
            //} while (userInput != null);


   }   
}
