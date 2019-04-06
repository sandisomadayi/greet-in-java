package net.greet;

import java.util.Map;

public interface Greeting {

    String greet(String userName, String language);
    Map<String, Integer> greeted();
    String greeted(String userName);
    String counter();
    void clearMap();
    String help();
}
