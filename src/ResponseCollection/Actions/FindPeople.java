/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection.Actions;

import library.ClientSocket;

/**
 *
 * @author alvian
 */
public class FindPeople {
    
    private static final ClientSocket clientSocket = new ClientSocket();
    
    public enum People{
        ALVIAN("alvian"),
        ANNA("anna"),
        JEFRI("jefri"),
        LINTONG("lintong"),
        MISS_MARGIANTI("missmargianti"),
        MISTER_DENNIS("misterdennis"),
        MISTER_ERY("misterery"),
        MISTER_MAULANA("mistermaulana"),
        MISTER_MUSA("mistermusa");
        
        private String name;
        
        People(String name){
            this.name = name;
        }
        
        private String getName(){
            return name;
        }
    }
    
    public static void find (People people) {
        System.out.println("[application] : looking for " + people.getName());        
        clientSocket.runMessage("find " + people.getName());
    }
    
    //        Main.Main.getSpeechRecognition().sendMessageSocket("find " + people.getName());
    
}
