/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author alvian
 */
public class MarkovChain {
    private Hashtable<String, Vector<String>> markovChain;
    private Random rnd;
    private ReadFile file;
    private String[] lines;

    public MarkovChain(String data_path) {
        try{
            markovChain = new Hashtable<String, Vector<String>>();
            file = new ReadFile(System.getProperty("user.dir") + data_path);
            lines = file.OpenFile();
            rnd = new Random();
            markovChain.put("_start", new Vector<String>());
            markovChain.put("_end", new Vector<String>());
        }catch(IOException e){
            System.out.println("[System] : failed to load file");
        }
    }
    
    public MarkovChain(){
        markovChain = new Hashtable<String, Vector<String>>();
        rnd = new Random();
        markovChain.put("_start", new Vector<String>());
        markovChain.put("_end", new Vector<String>());
    }
    
    public void addData(String data_path){
        try{
            file = new ReadFile(System.getProperty("user.dir") + data_path);
            lines = file.OpenFile();
            for(int i=0;i< lines.length;i++){
                addWords(lines[i]);
            }
        }catch(IOException e){
            System.out.println("[System] : failed to load file");
        }
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
        return newPhrase.toString();	
    }
    
}
