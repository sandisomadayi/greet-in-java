package greet;

import java.util.*;

import static greet.Language.*;

public class Greet implements Greeting {

    private String userName;
    private Language language;
    private int userNameCount = 1;
    private String command;
//    private String languageTwo = language.toString();

    Scanner scanner = new Scanner(System.in);
    private Map<String, Integer> userNameMap = new HashMap<>();

    public Greet(String userName, Language language) {
        this.userName = userName;
        this.language = language;
    }
    public String greet (String userName, Language language){
        //System.out.println("Please enter a username & a language to be greeted in: ");
        //command = scanner.nextLine();
        //  userName = scanner.next();
        // languageTwo = scanner.next();
//        System.out.println(Language.valueOf("language").getGreeting() + ", " + userName);
        if (language.toString() != "") {
            if (userNameMap.containsKey(userName)) {
                userNameMap.put(userName, userNameCount + 1);
            } else {
                userNameMap.put(userName, userNameCount);
            }
            //return language.getGreeting();
        }
        return English.getGreeting();
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

    public void exit () {
        System.exit(0);
    }
}
