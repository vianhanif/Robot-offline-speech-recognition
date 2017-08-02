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
    
    public FindPeople (People people) {
        ClientSocket clientSocket = new ClientSocket();
        clientSocket.runMessage("find " + people.getName());
        System.out.println("[application] : looking for " + people.getName());
    }
    
}
