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
public enum CollegeInformationCommands {
    WHAT_1("what ", "what is the vision of gunadarma university ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHO_1("who", "who are you", "", ActionType.COLLEGE_INFORMATION_WHO.id()),
    WHO_2("who", "who is the rector gunadarma ?", "", ActionType.COLLEGE_INFORMATION_WHO.id()),
    WHAT_2("what ", "what is the meaning of the name gunadarma university ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_3("what ", "what defines gunadarma ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_4("what ", "what is the mission of gunadarma ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_5("what ", "what are gunadarma students activities ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHEN_1("when ", "when did gunadarma university got ' listed ' ?", "", ActionType.COLLEGE_INFORMATION_WHEN.id()),
    WHEN_2("when ", "when did gunadarma university got ' equalized ' ?", "", ActionType.COLLEGE_INFORMATION_WHEN.id()),
    WHERE_1("where ", "where was gunadarma first located ?", "", ActionType.COLLEGE_INFORMATION_WHERE.id()),
    HOW_1("how ", "how did gunadarma firstly located ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_2("how ", "how did gunadarma name chosen ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_3("how ", "how did gunadarma built ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_4("how ", "how did gunadarma first founded ?", "", ActionType.COLLEGE_INFORMATION_HOW.id());

    private final String title = "Information about Gunadarma's Profile. Ask something like below : ";
    private final String said;
    private final String sample_said;
    private final String response;
    private final int action;

    CollegeInformationCommands(String said, String sample_said, String response, int action){
        this.said = said;
        this.sample_said = sample_said;
        this.response = response;
        this.action = action;
    }

    public static ArrayList items(){
        ArrayList<ArrayList> items = new ArrayList();
        for(int i=0;i<values().length;i++){
            ArrayList item = new ArrayList();
            item.add(values()[i].said);
            item.add(values()[i].sample_said);
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
