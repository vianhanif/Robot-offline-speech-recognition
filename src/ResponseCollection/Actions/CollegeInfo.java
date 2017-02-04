/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection.Actions;

import library.SpeechRecognition;

/**
 *
 * @author alvian
 */
public class CollegeInfo {
    public CollegeInfo(SpeechRecognition speech, String words){
        speech.speak(words);
    }
}
