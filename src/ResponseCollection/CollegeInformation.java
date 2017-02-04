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
public enum CollegeInformation {
    WHAT("what ", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHEN("when ", "", ActionType.COLLEGE_INFORMATION_WHEN.id()),
    WHERE("where ", "", ActionType.COLLEGE_INFORMATION_WHERE.id()),
    WHO("who ", "", ActionType.COLLEGE_INFORMATION_WHO.id()),
    HOW("how ", "", ActionType.COLLEGE_INFORMATION_HOW.id());;
    
    private final String title = "Information about Gunadarma's Vision and Mission. Ask something starts with : ";
    private final String said;
    private final String response;
    private final int action;
        
    CollegeInformation(String said, String response, int action){
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
