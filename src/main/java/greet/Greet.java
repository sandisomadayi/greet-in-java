package greet;

import java.util.HashMap;
import java.util.Map;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;
    private String command;

    private Map<String, Integer> userNameMap = new HashMap<>();

    public Greet(String userName, Language language) {
        this.userName = userName;
        this.language = language;
    }

    public String greet(String userName, Language language) {
        if (userNameMap.containsKey(userName)) {
            userNameMap.put(userName, userNameCount + 1);
        }
        else {
            userNameMap.put(userName, userNameCount);
        }
        return language.getGreeting();
    }

    public Map<String, Integer> greeted() {
        return userNameMap;
    }

    public int greeted(String userName) {
        return userNameMap.get(userName);
    }

    public int counter() {
        return userNameMap.size();
    }
    public void clear() {
        for (Map.Entry<String, Integer> entry : userNameMap.entrySet()) {
            entry.setValue(1);
        }
    }

    public void exit() {
        System.exit(0);
    }
}
