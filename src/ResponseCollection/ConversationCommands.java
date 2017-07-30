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
public enum ConversationCommands {
    RYUJI("ryuji", "hello too"),
    HI("hi", "hello too"),
    HELLO("hello", "hello too"),
    NICE_TO_MEET_YOU("nice to meet you", "nice to meet you too"),
    CAN_YOU_HELP("can you help", "what can i do for you"),
    THANKS("thank", "you are welcome");
    
    private final String title = "Conversation";
    private final String said;
    private final String response;
        
    ConversationCommands(String said, String response){
        this.said = said;
        this.response = response;
    }
    
    public static ArrayList items(){
        ArrayList<ArrayList> items = new ArrayList();
        for(int i=0;i<values().length;i++){
            ArrayList item = new ArrayList();
            item.add(values()[i].said);
            item.add(values()[i].response);
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
