package greet;

import java.util.Map;

public interface Greeting {

    String greet(String userName, Language language);
    Map<String, Integer> greeted();
    int greeted(String useName);
    int counter();
    void exit();
    Command help();
}
