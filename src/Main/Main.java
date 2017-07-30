/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ResponseCollection.CollegeInformationCommands;
import ResponseCollection.ConversationCommands;
import ResponseCollection.FindPeopleCommands;
import java.util.ArrayList;
import library.SpeechRecognition;


/**
 *
 * @author parallels
 */

public class Main {
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args){
        SpeechRecognition speechRecognition = new SpeechRecognition(args);
        speechRecognition.configure(
                SpeechRecognition.Config.WITH_VOICE,
                SpeechRecognition.Config.COLORED_CONSOLE,
                SpeechRecognition.Config.SHOW_RESPONSE
        );
        speechRecognition.setResponses(new ArrayList(){{
//                add(BasicCommands.items());
//                add(DirectionCommands.items());
//                add(BrowsingCommands.items());
                add(ConversationCommands.items());
                add(FindPeopleCommands.items());
                add(CollegeInformationCommands.items());
        }});
        speechRecognition.start();
    }
}