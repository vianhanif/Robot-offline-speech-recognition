/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection;

import java.util.ArrayList;

/**
 *
 * @author alvian
 */
public enum DirectionCommands {
    LEFT("go left","tuning left..."),
    RIGHT("go right", "turning right..."),
    BACKWARD("go backward", "moving backwards..."),
    FORWARD("go forward", "moving forwards..."),
    STOP("stop", "stopping");
    
    
    private final String said;
    private final String response;
        
    DirectionCommands(String said, String response){
        this.said = said;
        this.response = response;
    }
    
    public static ArrayList items(){
        ArrayList<ArrayList> items = new ArrayList();
        for(int i=0;i<values().length;i++){
            ArrayList item = new ArrayList();
            item.add(values()[i].said);
            item.add(values()[i].response);
            items.add(item);
        }
        return items;
    }
    
    public String said(){
        return said;
    }
    
    public String response(){
        return response;
    }
}
