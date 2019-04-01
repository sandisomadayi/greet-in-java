package greet;

import java.util.*;
import greet.Language;

public class Greet implements Greeting {

    Scanner scanner = new Scanner(System.in);
    private Map<String, Integer> userNameMap = new HashMap<>();
    private List<String> list = new ArrayList<>();
    private String userName;
    private int userNameCount = 1;
    private int greetCount;
    private Command command;
    private Language language;

    public Greet(String userName, Language languages) {
        this.command = command;
        this.userName = userName;
        this.language = languages;
    }


    public String greet(String userName, Language language) {
        //System.out.println("Please enter username: ");
        //userName = scanner.nextLine();
        //System.out.println("Language to be greeted in: ");
        //language = scanner.nextLine();
        if (userNameMap.containsKey(userName)) {
            userNameMap.put(userName, userNameCount+1);
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
        userNameMap = null;
    }

    public void exit() {
        System.exit(0);
    }

    public Command help() {
        return command;
    }
}
