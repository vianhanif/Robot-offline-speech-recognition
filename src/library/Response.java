/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvian
 */
public class Response {
    
    private List<ArrayList<ArrayList>> collection;
    private ColorizeConsole out;
    
    public Response(){
        this.collection = new ArrayList();
        try {
            out = new ColorizeConsole(System.out);
        } catch (UnsupportedEncodingException ex) {
            out.red("[Response] : Failed to setup colorized console");
        }
    }
    
    public ArrayList<ArrayList> get(int i){
        return collection.get(i);
    }
    
    public void add(ArrayList<ArrayList> obj){
        collection.add(obj);
    }
    
    public int size(){
        return collection.size();
    }
    
    public String getCommand(int i, int j){
        return String.format("%s", 
                collection.get(i).get(j).get(0).toString().toLowerCase());
    }
    
    public String getResponse(int i, int j){
        if(collection.get(i).get(j).size() > 2){
            runResponseAction(i, j);
        }
        return String.format("%s", 
                collection.get(i).get(j).get(1).toString().toLowerCase());
    }
    
    private void runResponseAction(int i, int j){
        collection.get(i).get(j).get(2);
    }
    
    public void ListCommand(){
        out.cyan("### Available commands");
        for(int i = 0; i< collection.size();i++){
            out.cyan("--- Command Group " + (i+1) + "---");
            for (int j =0;j<collection.get(i).size();j++){
                out.cyan((j+1) + ". " + getCommand(i, j));
            }
            System.out.println();            
        }
        out.cyan("### try say one of the commands");
    }
}