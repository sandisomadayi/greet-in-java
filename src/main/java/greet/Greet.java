package greet;

import java.util.*;

public class Greet implements Greeting {

    Scanner scanner = new Scanner(System.in);
    List<String> userNames = new ArrayList<>();
    private String userName;
    private int userNameCount = 1;
    private int greetCount;
    private Command command;
    private Language language;

    public Greet(Command command, String userName, Language languages) {
        this.command = command;
        this.userName = userName;
        this.language = languages;
    }


    public Language greet(String userName, Language language) {
        //System.out.println("Please enter username: ");
        //userName = scanner.nextLine();
        //System.out.println("Language to be greeted in: ");
        //language = scanner.nextLine();
        for (int i = 0; i <= userNames.size(); i++) {
            if (userNames.equals(userName)) {
                userNameCount++;
            }
            else {
                userNames.add(userName);
            }

        }
        return language;
    }

    public List<String> greeted() {
        for (int i = 0; i < userNames.size(); i++) {
            //return userNameMap.get(i);
        }
        if (userName == "") {
            return userNames;
        }
        return userNames;

    }

    public void exit() {
        System.exit(0);
    }

    public Command help() {
        return command;
    }
}
