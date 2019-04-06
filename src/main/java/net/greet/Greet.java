package net.greet;

import net.greet.languages.Language;

import java.util.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;
    private String languageTwo;
    private String[] inputs;
    private int count;

    private Map<String, Integer> userNameMap = new HashMap<>();

    public Greet(String userName, Language language) {
        this.userName = userName;
        this.language = language;
    }

    public String greet (String userName, String language){
//        System.out.println(Language.valueOf("inputs[1]").getGreeting() + ", " + userName);
        if (userNameMap.containsKey(userName.toLowerCase())) {
            userNameMap.put(userName.toLowerCase(), userNameMap.get(userName) + 1);
        } else {
            userNameMap.put(userName.toLowerCase(), userNameCount);
        }

        return Language.valueOf(language.toLowerCase()).getGreeting() + " " + userName;

    }

    public Map<String, Integer> greeted () {
        return userNameMap;
    }

    public String greeted (String userName){
        return "user name " + userName + " was greeted " + userNameMap.get(userName) + " time(s)";
    }

    public String counter () {
        return "the size of the map is " + userNameMap.size();
    }
    public void clearMap () {
        userNameMap.clear();
    }
    public void clear() {
        count = userNameMap.get(userName);
    }

    public String help () {
        return "Valid commands are:\ngreet\ngreeted\ncounter\nclear\nhelp\nexit";
    }

}
