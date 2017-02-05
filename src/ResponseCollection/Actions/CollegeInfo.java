/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection.Actions;

import info.debatty.java.stringsimilarity.Damerau;
import library.MarkovChain;
import library.SpeechRecognition;

/**
 *
 * @author alvian
 */
public class CollegeInfo {
    
    private MarkovChain markovChain;
    
    public CollegeInfo(SpeechRecognition speech, String words){
        markovChain = new MarkovChain();
        markovChain.setDataSet("/data/");
        String response = markovChain.getKnowledge(words);
        System.out.println("[Machine Learning] question : "  + words);
        System.out.println("[Machine Learning] answer   : "  + response);
        speech.speak(response);
    }
    
//    public static void main(String args[]){
//        Damerau l = new Damerau();
////        System.out.println(l.similarity("what is your name", "my name is Alvian."));
////        System.out.println(l.similarity("what is your name", "i am twenty years old."));
////        System.out.println(l.similarity("what is your name", "i am living in depok."));
////        System.out.println(l.similarity("what is your name", "i live with my family.") + "\n");
//        System.out.println(l.distance("what is your name", "my name is Alvian."));
//        System.out.println(l.distance("what is your name", "i am twenty years old."));
//        System.out.println(l.distance("what is your name", "i am living in depok."));
//        System.out.println(l.distance("what is your name", "i live with my family."));
//        
//        System.out.println(l.distance("how old are you", "my name is Alvian."));
//        System.out.println(l.distance("how old are you", "my family."));
//        System.out.println(l.distance("how old are you", "i am twenty years old."));
//        System.out.println(l.distance("how old are you", "i am living in depok."));
//        System.out.println(l.distance("how old are you", "i live with my family."));
//    }
    
}
