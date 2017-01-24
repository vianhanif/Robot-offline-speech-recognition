/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection;

import java.util.ArrayList;
import ResponseCollection.Actions.ActionType;

/**
 *
 * @author alvian
 */
public enum DirectionCommands {
    LEFT("go left","turning left...", ActionType.DIRECTION_LEFT.id()),
    RIGHT("go right", "turning right...", ActionType.DIRECTION_RIGHT.id()),
    BACKWARD("go backward", "moving backwards...", ActionType.DIRECTION_BACKWARD.id()),
    FORWARD("go forward", "moving forwards...", ActionType.DIRECTION_FORWARD.id()),
    STOP("stop", "stopping", ActionType.DIRECTION_STOP.id());
    
    private final String title = "Directions";
    private final String said;
    private final String response;
    private final int action;
        
    DirectionCommands(String said, String response, int action){
        this.said = said;
        this.response = response;
        this.action = action;
    }
    
    public static ArrayList items(){
        ArrayList<ArrayList> items = new ArrayList();
        for(int i=0;i<values().length;i++){
            ArrayList item = new ArrayList();
            item.add(values()[i].said);
            item.add(values()[i].response);
            item.add(values()[i].action);
            item.add(values()[i].title);
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
