package net.greet;

import java.util.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;

    private static final String GREEN = "\033[1;32m";
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String RED = "\033[0;31m";

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
            return YELLOW + Language.valueOf(language.toLowerCase()).getGreeting() + userName + RESET;
        }catch (IllegalArgumentException e) {
            return YELLOW + Language.valueOf("english").getGreeting() + " " + userName + RESET;
        }

    }

    public String greeted(String userName) {
        try {
            if (userName == null) {
                if (userNameMap.isEmpty()) {
                    return CYAN + "no one is greeted" + RESET;
                }
                return userNameMap.toString();

            } else {
                return PURPLE + "user name " + userName + " was greeted " + userNameMap.get(userName) + " time(s)" + RESET;
            }
        }
        catch (NullPointerException e) {
            if (userNameMap.isEmpty()) {
                return CYAN + "no one is greeted" + RESET;
            }
            else {
                return CYAN + "no one is greeted" + RESET;
            }
        }
    }

    public String counter () {
        return BLUE + "number of name(s) greeted " + userNameMap.size() + RESET;
    }

    public String clear(String userName) {
        try {
            if (userName == null) {
                userNameMap.clear();
                return RED + "All names deleted" + RESET;
            }
            else {
                userNameMap.remove(userName);
                return RED + userName + " removed from the map" + RESET;
            }
        }
        catch (NullPointerException e) {
            userNameMap.remove(userName);
            return RED + "All names deleted" + RESET;
        }
    }

    public String help () {
        return GREEN + "Valid commands are:\ngreet\ngreeted\ncount\nclear\nhelp\nexit\n" + RESET;
    }

}
