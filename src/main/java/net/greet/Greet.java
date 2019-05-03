package net.greet;

import java.util.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;

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
            return Language.valueOf(language.toLowerCase()).getGreeting() + userName;
        }catch (IllegalArgumentException e) {
            return Language.valueOf("english").getGreeting() + " " + userName;
        }

    }

    public String greeted(String userName) {
        try {
            if (userName == null) {
                if (userNameMap.isEmpty()) {
                    return "no one is greeted";
                }
                return userNameMap.toString();

            } else {
                return userName + " was greeted " + userNameMap.get(userName) + " time(s)";
            }
        }
        catch (NullPointerException e) {
            if (userNameMap.isEmpty()) {
                return "no one is greeted";
            }
            else {
                return "no one is greeted";
            }
        }
    }

    public String counter () {
        return "name(s) greeted " + userNameMap.size();
    }

    public String clear(String userName) {
        try {
            if (userName == null) {
                userNameMap.clear();
                return "All names deleted";
            }
            else {
                userNameMap.remove(userName);
                return userName + " removed from the map";
            }
        }
        catch (NullPointerException e) {
            userNameMap.remove(userName);
            return "All names deleted";
        }
    }

    public String help () {
        return "Valid commands are:\ngreet - with a name will greet the person in a specified language\ngreeted - shows how many times a person was greeted\ncount - shows how many people were greeted\nclear - deletes a name or all names that were greeted\nhelp - displays commands to use\nexit - exits the application";
    }

}
