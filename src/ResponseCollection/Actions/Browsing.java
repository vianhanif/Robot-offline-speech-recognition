/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponseCollection.Actions;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author alvian
 */
public final class Browsing{
    
    public enum Browse{
        GOOGLE("https://google.com"),
        FACEBOOK("https://facebook.com"),
        YOUTUBE("https://youtube.com"),
        TWITTER("https://twitter.com"),
        ALLKPOP("https://allkpo.com");
        
        private String link;
        
        Browse(String link){
            this.link = link;
        }
        
        private String link(){
            return link;
        }
    }
    
    private Browse browse;
        
    public Browsing(Browse browse){
        this.browse = browse;
        System.out.println("[System] : opening "+ this.browse.link() +"....");
//        run();
    }
    
    public void run() throws RuntimeException{
        openWebpage(browse.link());
    }
    
    public void openWebpage(String link){
        try{
            URL url = new URL(link);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(url.toURI());
                } catch (Exception e) {
                    System.out.println("[System] : failed to process browser");
                }
            }else{
                System.out.println("[System] : failed to find supported browser");
            }
        }catch(MalformedURLException e){
            System.out.println("[System] : failed to open browser");
        }
    }
}
