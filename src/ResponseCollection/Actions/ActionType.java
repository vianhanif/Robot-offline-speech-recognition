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
public enum ActionType {
    DIRECTION_LEFT(1),
    DIRECTION_RIGHT(2),
    DIRECTION_BACKWARD(3),
    DIRECTION_FORWARD(4),
    DIRECTION_STOP(5),
    
    BROWSE_GOOGLE(6),
    BROWSE_YOUTUBE(7),
    BROWSE_FACEBOOK(8),
    BROWSE_TWITTER(9),
    BROWSE_ALLKPOP(10),
    
    COLLEGE_INFORMATION_WHAT(11),
    COLLEGE_INFORMATION_WHEN(12),
    COLLEGE_INFORMATION_WHERE(13),
    COLLEGE_INFORMATION_WHO(14),
    COLLEGE_INFORMATION_HOW(15),
    
    FIND_ALVIAN(16),
    FIND_ANNA(17),
    FIND_JEFRI(18),
//    FIND_LINTONG(19),
    FIND_MISS_MARGIANTI(20),
    FIND_MISTER_DENNIS(21),
    FIND_MISTER_ERY(22),
    FIND_MISTER_MAULANA(23),
    FIND_MISTER_MUSA(24);

    private final int type;

    ActionType(int type) {
        this.type = type;
    }

    public int id() {
        return type;
    }

    public static void runAction(SpeechRecognition speech, int type, String userWords){
        if(type == ActionType.DIRECTION_LEFT.id()){new Direction("left");}
        if(type == ActionType.DIRECTION_RIGHT.id()){new Direction("right");}
        if(type == ActionType.DIRECTION_BACKWARD.id()){new Direction("backward");}
        if(type == ActionType.DIRECTION_FORWARD.id()){new Direction("forward");}
        if(type == ActionType.DIRECTION_STOP.id()){new Direction("null direction, stopping");}
        if(type == ActionType.BROWSE_GOOGLE.id()){new Browsing(Browsing.Browse.GOOGLE);}
        if(type == ActionType.BROWSE_FACEBOOK.id()){new Browsing(Browsing.Browse.FACEBOOK);}
        if(type == ActionType.BROWSE_YOUTUBE.id()){new Browsing(Browsing.Browse.YOUTUBE);}
        if(type == ActionType.BROWSE_ALLKPOP.id()){new Browsing(Browsing.Browse.ALLKPOP);}
        if(type == ActionType.BROWSE_TWITTER.id()){new Browsing(Browsing.Browse.TWITTER);}
        if(type == ActionType.COLLEGE_INFORMATION_WHAT.id()){new CollegeInformation(speech, "what", userWords);}
        if(type == ActionType.COLLEGE_INFORMATION_WHEN.id()){new CollegeInformation(speech, "when", userWords);}
        if(type == ActionType.COLLEGE_INFORMATION_WHERE.id()){new CollegeInformation(speech, "where", userWords);}
        if(type == ActionType.COLLEGE_INFORMATION_WHO.id()){new CollegeInformation(speech, "who", userWords);}
        if(type == ActionType.COLLEGE_INFORMATION_HOW.id()){new CollegeInformation(speech, "how", userWords);}
        if(type == ActionType.FIND_ALVIAN.id()){FindPeople.find(FindPeople.People.ALVIAN);}
        if(type == ActionType.FIND_ANNA.id()){FindPeople.find(FindPeople.People.ANNA);}
        if(type == ActionType.FIND_JEFRI.id()){FindPeople.find(FindPeople.People.JEFRI);}
//        if(type == ActionType.FIND_LINTONG.id()){FindPeople.find(FindPeople.People.LINTONG);}
        if(type == ActionType.FIND_MISS_MARGIANTI.id()){FindPeople.find(FindPeople.People.MISS_MARGIANTI);}
        if(type == ActionType.FIND_MISTER_DENNIS.id()){FindPeople.find(FindPeople.People.MISTER_DENNIS);}
        if(type == ActionType.FIND_MISTER_ERY.id()){FindPeople.find(FindPeople.People.MISTER_ERY);}
        if(type == ActionType.FIND_MISTER_MAULANA.id()){FindPeople.find(FindPeople.People.MISTER_MAULANA);}
        if(type == ActionType.FIND_MISTER_MUSA.id()){FindPeople.find(FindPeople.People.MISTER_MUSA);}
        
    }
}
