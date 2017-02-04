/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvian
 */
public class ReadFile{

    private final String path;

    public ReadFile(String file_path) {
        path = file_path;
    }

    public String[] OpenFile() throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        int i;

        for (i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }
        textReader.close();
        return textData;
    }

    public int readLines() throws IOException {
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();
        return numberOfLines;
    }
    
    static public List<ReadFile> getFiles(String path){
        File f = new File(System.getProperty("user.dir") + path);
        File[] tmp_files = f.listFiles();
        List<ReadFile> files = new ArrayList();
        for(File file : tmp_files){
            ReadFile alocated_file = new ReadFile(file.getAbsolutePath());
            files.add(alocated_file);
        }
        return files;
    }
    
    public String getPath(){
        return path;
    }

}
