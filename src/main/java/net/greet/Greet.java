package net.greet;

import java.util.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;

    private Map<String, Integer> userNameMap = new HashMap<>();

    public String greet (String userName, String language) {
        if (userNameMap.containsKey(userName)) {
            userNameMap.put(userName, userNameMap.get(userName) + 1);
        } else {
            userNameMap.put(userName, userNameCount);
        }

        try {
            return Language.valueOf(language.toLowerCase()).getGreeting() + userName;
        }catch (Exception e) {
            return Language.valueOf("english").getGreeting() + " " + userName;
        }

    }

    public String greeted(String userName) {
        try {
            if (userName.equals("")) {
                if (userNameMap.isEmpty()) {
                    return "no one is greeted";
                }
                return userNameMap.toString();

            } else {
                if (userNameMap.containsKey(userName)) {
                    return userName + " was greeted " + userNameMap.get(userName) + " time(s)";
                }
                return userName + " has not been greeted, try greeting it first";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "no one is greeted";
        }
    }

    public String counter () {
        return "name(s) greeted: " + userNameMap.size();
    }

    public String clear(String userName) {
        try {
            if (userName.equals("")) {
                userNameMap.clear();
                return "All names deleted.";
            }
            else {
                if (userNameMap.containsKey(userName)) {
                    userNameMap.remove(userName);
                    return userName + " deleted.";
                }
                return userName + " has not been greeted, try greeting it first.";
            }
        }
        catch (Exception e) {
            userNameMap.remove(userName);
            return "All names deleted";
        }
    }

    public String help () {
        return "Valid commands are:\ngreet - with a name will greet the person in a specified language\ngreeted - shows how many times a person was greeted\ncount - shows how many people were greeted\nclear - deletes a name or all names that were greeted\nhelp - displays commands to use\nexit - exits the application";
    }

}
