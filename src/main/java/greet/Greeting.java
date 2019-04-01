package greet;

import java.util.List;
import java.util.Map;

public interface Greeting {

    Language greet(String userName, Language language);
    List greeted();
    void exit();
    Command help();
}
