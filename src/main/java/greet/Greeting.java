package greet;

import java.util.Map;

public interface Greeting {

    String greet(String userName, Language language);
    Map<String, Integer> greeted();
    int greeted(String userName);
    int counter();
    void clearMap();
    void exit();
    //Command help();
}
