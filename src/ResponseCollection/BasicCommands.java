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
public enum BasicCommands {
    BANK("go to the bank", "finding a route to the bank..."),
    OFFICE("go to the office", "Going to the office by car..."),
    RESTAURANT("go to the restaurant","looking for the restaurant in town..."),
    OPENFILE("open the files", "opening some files in drive...."),
    OPENWINDOW("open the window", "opening the window to breath..."),
    OPENCOMPUTER("open the computer", "opening computer to start working...");
    
    private final String title = "Sample Command";
    private final String said;
    private final String response;
        
    BasicCommands(String said, String response){
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
