package net.greet;

public interface Greeting {

    String greet(String userName, String language);
    String greeted(String userName);
    String counter();
    String clear(String name);
    String help();
}
