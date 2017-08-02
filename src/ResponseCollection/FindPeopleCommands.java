/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection;

import ResponseCollection.Actions.ActionType;
import java.util.ArrayList;

/**
 *
 * @author alvian
 */
public enum FindPeopleCommands {
    ALVIAN("find alvian", "looking for information about alvian", ActionType.FIND_ALVIAN.id()),
    ANNA("find anna", "looking for information about anna", ActionType.FIND_ANNA.id()),
    JEFRI("find jefri", "looking for information about jefri", ActionType.FIND_JEFRI.id()),
    LINTONG("find lintong", "looking for information about lintong", ActionType.FIND_LINTONG.id()),
    MARGIANTI("find missmargianti", "looking for information about missmargianti", ActionType.FIND_MISS_MARGIANTI.id()),
    DENNIS("find misterdennis", "looking for information about misterdennis", ActionType.FIND_MISTER_DENNIS.id()),
    ERY("find misterery", "looking for information about misterery", ActionType.FIND_MISTER_ERY.id()),
    MAULANA("find mistermaulana", "looking for information about mistermaulana", ActionType.FIND_MISTER_MAULANA.id()),
    MUSA("find mistermusa", "looking for information about mistermusa", ActionType.FIND_MISTER_MUSA.id());
    
    private final String title = "Find People";
    private final String said;
    private final String response;
    private final int action;
        
    FindPeopleCommands(String said, String response, int action){
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
