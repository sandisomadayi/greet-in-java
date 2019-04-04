package greet;

import java.util.*;

import static greet.Language.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;
    private String languageTwo;
    private String[] inputs;

    private Map<String, Integer> userNameMap = new HashMap<>();

    public Greet(String userName, Language language) {
        this.userName = userName;
        this.language = language;
    }

    public String greet (String userName, Language language){
//        System.out.println(Language.valueOf("inputs[1]").getGreeting() + ", " + userName);
        if (userNameMap.containsKey(userName.toLowerCase())) {
            userNameMap.put(userName.toLowerCase(), userNameCount + 1);
        } else {
            userNameMap.put(userName.toLowerCase(), userNameCount);
        }
        return "Hello " + userName;
//        switch(language) {
//            case Xhosa: {
//                return Xhosa.getGreeting();
//            }
//            case English: {
//                return English.getGreeting();
//            }
//            case Zulu: {
//                return Zulu.getGreeting();
//            }
//            case Sotho: {
//                return Sotho.getGreeting();
//            }
//            default: {
//                return English.getGreeting();
//            }
//         }
    }

    public Map<String, Integer> greeted () {
        return userNameMap;
    }

    public int greeted (String userName){
        return userNameMap.get(userName);
    }

    public int counter () {
        return userNameMap.size();
    }
    public void clearMap () {
        userNameMap.clear();
    }

    public String help () {
        return "Commands to use\nGreet\nGreeted\ncounter\nClear\nHelp\nExit";
    }

}
