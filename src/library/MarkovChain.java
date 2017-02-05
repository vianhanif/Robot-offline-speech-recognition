/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import info.debatty.java.stringsimilarity.JaroWinkler;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author alvian
 */
public class MarkovChain {
    private Hashtable<String, Vector<String>> markovChain = new Hashtable<String, Vector<String>>();
    private Random rnd = new Random();;
    private ReadFile file;
    private String[] lines;
    private JaroWinkler compare = new JaroWinkler();

    public MarkovChain(String data_path) {
        try{
            file = new ReadFile(System.getProperty("user.dir") + data_path);
            lines = file.OpenFile();
            markovChain.put("_start", new Vector<String>());
            markovChain.put("_end", new Vector<String>());
        }catch(IOException e){
            System.out.println("[System] : failed to load file");
        }
    }
    
    public MarkovChain(){
        markovChain.put("_start", new Vector<String>());
        markovChain.put("_end", new Vector<String>());
    }
    
    public void setDataSet(String dir_path){
        List<ReadFile> dataSets = ReadFile.getFiles(dir_path);
        for(ReadFile file : dataSets){
            addData(file.getPath());
        }
    }
    
    public void addData(String data_path){
        if(!data_path.contains(".DS_Store")){
            try{
                file = new ReadFile(data_path);
                lines = file.OpenFile();
                for(int i=0;i< lines.length;i++){
                    addWords(lines[i]);
                }
            }catch(IOException e){
                System.out.println("[System] : failed to load file");
            }
        }
    }
    
    public String getKnowledge(String word){
        String[] phrase = new String[markovChain.size()];
        double[] similarity = new double[markovChain.size()];
        for(int i = 0;i< markovChain.size();i++){
            String generated = generateSentence();
            phrase[i] = generated;
            similarity[i] = compare.similarity(word, generated);
            System.out.println(i + " : " + "[" + similarity[i] + "] "+ phrase[i]);
        }
//        return phrase[getMax(similarity)] + " [" + similarity[getMax(similarity)] + "]";
        return phrase[getMax(similarity)];
    }
    
    private int getMax(double[] inputArray){ 
        double maxValue = inputArray[0]; 
        int index = 0;
        for(int i=1;i < inputArray.length;i++){ 
           if(inputArray[i] == 0.0){
               continue;
           }else{
                if(inputArray[i] > maxValue){ 
                     maxValue = inputArray[i]; 
                     index = i;
                }  
           }
        } 
//        System.out.println("max " + " = " + index + " : "+ maxValue);
        return index; 
    }
    
    private int getMin(double[] inputArray){ 
        double minValue = inputArray[0]; 
        int index = 0;
        for(int i=1;i < inputArray.length;i++){ 
           if(inputArray[i] == 0.0){
               continue;
           }else{
                if(inputArray[i] < minValue){ 
                     minValue = inputArray[i]; 
                     index = i;
                }  
           }
        } 
//        System.out.println("max " + " = " + index + " : "+ minValue);
        return index; 
    }
    
    /*
     * Add words
     */
    public void addWords(String phrase) {
	// put each word into an array
	String[] words = phrase.split(" ");
				
	// Loop through each word, check if it's already added
	// if its added, then get the suffix vector and add the word
	// if it hasn't been added then add the word to the list
	// if its the first or last word then select the _start / _end key
		
	for (int i=0; i<words.length; i++) {
					
            // Add the start and end words to their own
            if (i == 0) {
		Vector<String> startWords = markovChain.get("_start");
		startWords.add(words[i]);
				
		Vector<String> suffix = markovChain.get(words[i]);
		if (suffix == null) {
                	suffix = new Vector<String>();
			suffix.add(words[i+1]);
			markovChain.put(words[i], suffix);
		}
				
            } else if (i == words.length-1) {
		Vector<String> endWords = markovChain.get("_end");
		endWords.add(words[i]);
				
		} else {	
                    Vector<String> suffix = markovChain.get(words[i]);
                    if (suffix == null) {
			suffix = new Vector<String>();
			suffix.add(words[i+1]);
			markovChain.put(words[i], suffix);
                    } else {
			suffix.add(words[i+1]);
			markovChain.put(words[i], suffix);
                    }
		}
            }
	}
    
    /*
     * Generate a markov phrase  
     */
    public String generateSentence() {  
        
	// Vector to hold the phrase
	Vector<String> newPhrase = new Vector<String>();
		
	// String for the next word
	String nextWord = "";
				
	// Select the first word
	Vector<String> startWords = markovChain.get("_start");
	int startWordsLen = startWords.size();
	nextWord = startWords.get(rnd.nextInt(startWordsLen));
	newPhrase.add(nextWord);
		
        // Keep looping through the words until we've reached the end
        while (nextWord.charAt(nextWord.length()-1) != '.') {
            Vector<String> wordSelection = markovChain.get(nextWord);
            int wordSelectionLen = wordSelection.size();
            nextWord = wordSelection.get(rnd.nextInt(wordSelectionLen));
            newPhrase.add(nextWord);
	}
        String sentence = "";
        for (String chain : newPhrase){
            sentence += chain + " ";
        }
        return sentence;
    }
    
}
