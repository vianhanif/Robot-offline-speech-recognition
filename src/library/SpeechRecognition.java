/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author parallels
 */

import Main.Main;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

class Speech{
    public enum type {
        WITH_VOICE,
        NO_VOICE;
        
        int id(){
            switch(this){
                case WITH_VOICE:
                    return 1;
                case NO_VOICE:
                    return 0;
                default:
                    return 1;
            }
        }
    }
    
    protected enum get {
        MIC_ERROR,
        ERROR;
        
        String respone(){
            switch (this){
                case MIC_ERROR:
                    return "cannot start your microphone";
                case ERROR:
                    return "I can't hear what you said";
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    }
}


public class SpeechRecognition extends Speech{
    private Recognizer recognizer;
    private ConfigurationManager cm;
    private VoiceManager vm;
    private Voice voice;
    private int open_voice = 0;
    
    public SpeechRecognition(String[] args){
        if (args.length > 0) {
            cm = new ConfigurationManager(args[0]);
        } else {
            cm = new ConfigurationManager(Main.class.getResource("config.xml"));
        }
        recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();
    }
    
    public void configure(Speech.type type){
        open_voice = type.id();
        if(open_voice == 1){
            setupVoice();
        }
    }
    
    private void setupVoice(){
        vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.setStyle("casual");
        voice.allocate();
        voice.setVolume(100);
        voice.setRate(130);
        voice.setPitch(130);
    }
    
    private void speak(String text){
        if(open_voice == 1 && text != null){
            voice.speak(text);
        }
    }
        
    
    public void start(){
        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println(get.MIC_ERROR.respone());
            recognizer.deallocate();
            System.exit(1);
        }
        
        // loop the recognition until the programm exits.
        while (true) {

            Result result = recognizer.recognize();
            String resultText = result.getBestResultNoFiller();

            if (!resultText.equals("")) {
                System.out.println("You >> " + resultText);
                speak(resultText);
                if(resultText.equals("quit system please")){
                    voice.deallocate();
                    System.exit(0);
                }
            } else {
                System.out.println("Bot >> " + get.ERROR.respone());
                speak(get.ERROR.respone());
            }
        }
    }
}
