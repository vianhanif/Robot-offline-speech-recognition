/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alvian
 */
public class TagMatch {

    private Random rnd = new Random();
    ;
    private ReadFile file;
    private String[] lines;
    private List<HashMap<String, HashMap<String, String>>> data = new ArrayList();

    public void setDataSet(String dir_path) {
        List<ReadFile> dataSets = ReadFile.getFiles(dir_path);
        for (ReadFile file : dataSets) {
            addData(file.getPath());
        }
    }

    public void addData(String data_path) {
        if (!data_path.contains(".DS_Store")) {
            try {
                file = new ReadFile(data_path);
                lines = file.OpenFile();
                for (int i = 0; i < lines.length; i++) {
                    addWords(lines[i]);
                }
            } catch (IOException e) {
                System.out.println("[System] : failed to load file");
            }
        }
    }

    public void addWords(String words) {
        String[] list = words.split(":");
        String header = null;
        String value = null;
        for (int i = 0; i < list.length; i += 3) {
            HashMap<String, String> header_tags = new HashMap();
            header = list[0];
            value = list[list.length - 1];
            for (int j = 0; j < list.length - 2; j++) {
                header_tags.put(list[j + 1], value);
            }
            HashMap<String, HashMap<String, String>> item = new HashMap();
            item.put(header, header_tags);
            data.add(item);
        }
    }

    public List<List<String>> findByKey(String search, String[] tags) {
        List<List<String>> key_list = new ArrayList();
        for (int i = 0; i < data.size(); i += 2) {
            HashMap item = data.get(i).get(search);
            List<String> key_pairs = new ArrayList();
            if (item != null) {
                int tag_exist = 0;
                String tmp_value = null;
                for (String tag : tags) {
                    for (Object key : item.keySet()) {
                        if (key.toString().contains(tag)) {
                            tag_exist++;
                            tmp_value = item.get(key).toString();
                        }
                    }
                }
                if (tmp_value != null) {
                    key_pairs.add(tmp_value);
                    key_pairs.add(String.valueOf(tag_exist));
                    key_list.add(key_pairs);
                }
            }
        }
        return key_list;
    }

    public String getMatch(int accuracy, String search, String[] tags) {
        List<List<String>> items = this.findByKey(search, tags);
        List<String> matches = new ArrayList();
        for (List<String> item : items) {
            if (Integer.parseInt(item.get(1)) >= accuracy) {
                matches.add(item.get(0));
            }
        }
        System.out.println("macthes : " + matches.size());
        return matches.size() > 0 ? matches.get(new Random().nextInt(matches.size())) : null;
    }

//    public static void main(String args[]){
//        TagMatch a = new TagMatch();
//        a.setDataSet("/base-data/");
//        String[] tags = "how did gunadarma built".split(" ");
//        System.out.println(a.getMatch(1, "how", tags));
//    }
}
