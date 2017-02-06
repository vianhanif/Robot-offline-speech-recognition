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
    WHAT_1("what ", "What is the vision of Gunadarma University ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_2("what ", "What is the meaning of the name Gunadarma University ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_3("what ", "What defines Gunadarma ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHAT_4("what ", "What is the mission of Gunadarma ?", "", ActionType.COLLEGE_INFORMATION_WHAT.id()),
    WHEN_1("when ", "When did Gunadarma University got 'Listed' ?", "", ActionType.COLLEGE_INFORMATION_WHEN.id()),
    WHEN_2("when ", "When did Gunadarma University got 'Equalized' ?", "", ActionType.COLLEGE_INFORMATION_WHEN.id()),
    WHERE_1("where ", "Where was Gunadarma first located ?", "", ActionType.COLLEGE_INFORMATION_WHERE.id()),
    HOW_1("how ", "How did gunadarma firstly located ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_2("how ", "How did gunadarma name chosen ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_3("how ", "How did gunadarma built ?", "", ActionType.COLLEGE_INFORMATION_HOW.id()),
    HOW_4("how ", "How did gunadarma first founded ?", "", ActionType.COLLEGE_INFORMATION_HOW.id());

    private final String title = "Information about Gunadarma's Profile. Ask something like below : ";
    private final String said;
    private final String sample_said;
    private final String response;
    private final int action;

    CollegeInformation(String said, String sample_said, String response, int action){
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
