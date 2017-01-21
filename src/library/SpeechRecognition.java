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
import java.io.UnsupportedEncodingException;


public class SpeechRecognition extends Speech{
    private final Recognizer recognizer;
    private final ConfigurationManager cm;
    private ColorizeConsole out;
    private VoiceManager vm;
    private Voice voice;
    private int open_voice = 0;
    private int colorize_console = 0;
    
    public SpeechRecognition(String[] args){
        if (args.length > 0) {
            cm = new ConfigurationManager(args[0]);
        } else {
            cm = new ConfigurationManager(Main.class.getResource("config.xml"));
        }
        recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();
    }
    
    public void configure(Speech.Config type, Speech.Config colored){
        open_voice = type.id();
        colorize_console = colored.id();
        if(open_voice == 1){
            setupVoice();
        }
        if(colorize_console == 1){
            setupColoredConsole();
        }
    }
    
    public void configure(){
        open_voice = Config.NO_VOICE.id();
        colorize_console = Config.NON_COLORED_CONSOLE.id();
    }
    
    private void setupColoredConsole(){
        try {
            out = new ColorizeConsole(System.out);
        } catch (UnsupportedEncodingException ex) {
            output(Color.RED, Get.COLORING_CONSOLE_ERROR.respone());
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
    
    private void output(Color color, String text){
        if(colorize_console == 1){
            switch(color){
                case GREEN: out.green(text);break;
                case YELLOW: out.yellow(text);break;
                case RED: out.red(text);break;
                case WHITE: out.white(text);break;
                case CYAN: out.cyan(text);break;
                case BLUE: out.blue(text);break;
                case BLACK: out.black(text);break;
            }
        }else{
            System.out.println(text);
        }
    }
        
    
    public void start(){
        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        output(Color.BLUE, "say something...");
        if (!microphone.startRecording()) {
            output(Color.RED, Get.MIC_ERROR.respone());
            recognizer.deallocate();
            System.exit(1);
        }
        
        // loop the recognition until the programm exits.
        while (true) {

            Result result = recognizer.recognize();
            String resultText = result.getBestResultNoFiller();

            if (!resultText.equals("")) {
                output(Color.GREEN, "You >> " + resultText);
                speak(resultText);
                if(resultText.equals("quit system please")){
                    voice.deallocate();
                    System.exit(0);
                }
            } else {
                output(Color.YELLOW, "Bot >> " + Get.ERROR.respone());
                speak(Get.ERROR.respone());
            }
        }
    }
}


class Speech{
   
    public enum Config {
        WITH_VOICE(1),
        NO_VOICE(0),
        COLORED_CONSOLE(1),
        NON_COLORED_CONSOLE(0);
        
        private int id;
        Config(int id){
            this.id = id;
        }
        
        int id(){
            return id;
        }
    }
    
    protected enum Color{
        YELLOW(0),
        GREEN(1),
        RED(2),
        BLUE(3),
        WHITE(4),
        CYAN(5),
        PURPLE(6),
        BLACK(7);
        
        private int id;
        
        Color(int id){
            this.id = id;
        }
        
        int id(){
            return id;
        }
    }
    
    protected enum Get {
        MIC_ERROR("cannot start your microphone"),
        COLORING_CONSOLE_ERROR("error colorizing console"),
        ERROR("I can't hear what you said");
        
        private String text;
        
        Get(String text){
            this.text = text;
        }
        
        String respone(){
            return text;
        }
    }
}
