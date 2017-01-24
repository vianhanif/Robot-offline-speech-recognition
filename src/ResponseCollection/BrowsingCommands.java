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
public enum BrowsingCommands {
    GOOGLE("open google", "opening google...", ActionType.BROWSE_GOOGLE.id()),
    FACEBOOK("open facebook", "opening facebook...", ActionType.BROWSE_FACEBOOK.id()),
    YOUTUBE("open youtube", "opening youtube...", ActionType.BROWSE_TWITTER.id()),
    TWITTER("open twitter", "opening twitter...", ActionType.BROWSE_TWITTER.id()),
    ALLKPOP("open allkpop", "opening allkpop...", ActionType.BROWSE_ALLKPOP.id());
    
    private final String title = "Browsing Online";
    private final String said;
    private final String response;
    private final int action;
        
    BrowsingCommands(String said, String response, int action){
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
