package greet;

import org.junit.jupiter.api.Test;

import static greet.Language.English;
import static greet.Language.Xhosa;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void languageTest() {
        Greet greet = new Greet(Command.greet, "sandiso", Xhosa);
        greet.greet("sandiso", Xhosa);
        greet.greet("sandiso", Xhosa);
        greet.greet("sandman", Xhosa);

        System.out.println(greet.greeted());
        System.out.println(greet.help());
        //System.out.println(greet.greet("main", English));
        assertEquals(Xhosa, greet.greet("sandiso", Xhosa));
    }
}
