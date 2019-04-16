package net.greet;

import java.util.*;

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

    public String greet (String userName, String language) {
//        System.out.println(Language.valueOf("inputs[1]").getGreeting() + ", " + userName);
        if (userNameMap.containsKey(userName.toLowerCase())) {
            userNameMap.put(userName.toLowerCase(), userNameMap.get(userName) + 1);
        } else {
            userNameMap.put(userName.toLowerCase(), userNameCount);
        }

        try {
            return Language.valueOf(language.toLowerCase()).getGreeting() + " " + userName;
        }catch (IllegalArgumentException e) {
            return Language.valueOf("english").getGreeting() + " " + userName;
        }

    }

    public String greeted(String userName) {
        try {
            if (userName == null) {
                return userNameMap.toString();
            } else {
                return "user name " + userName + " was greeted " + userNameMap.get(userName) + " time(s)";
            }
        }
        catch (NullPointerException e) {
            if (userNameMap.isEmpty() == true) {
                return "no one is greeted";
            }
            else {
                return userNameMap.toString();
            }
        }
    }

    public String counter () {
        return "number of name(s) greeted " + userNameMap.size();
    }

    public String clear(String userName) {
        try {
            if (userName == null) {
                userNameMap.clear();
                return "map cleared";
            }
            else {
                userNameMap.remove(userName);
                return userName + " removed from the map";
            }
        }
        catch (NullPointerException e) {
            userNameMap.remove(userName);
            return userName + " removed from the map";
        }
    }

    public String help () {
        return "Valid commands are:\ngreet\ngreeted\ncount\nclear\nhelp\nexit\n";
    }

}
