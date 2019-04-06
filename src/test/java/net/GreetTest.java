package net;

import net.greet.Greet;
import net.greet.languages.Language;
import org.junit.jupiter.api.Test;

//import static Language.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void shouldReturnGreetingTest() {
        Greet greet = new Greet("sandiso", Language.english);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        //System.out.println(greet.greet("sandiso", Language.Xhosa));
        assertEquals("Hallo me", greet.greet("me", "Afrikaans"));
    }
    @Test
    public void shouldReturnGreetedUserNamesTest() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");


        assertEquals("user name sandiso was greeted 2 time(s)", greet.greeted("sandiso"));
        //assertEquals("{anotherMe=1, me=1, sandman=1, sandiso=2}", greet.greeted().toString());
    }

    @Test
    public void shouldCountUserNames() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");


        assertEquals("the size of the map is 4", greet.counter());
    }

    @Test
    public void mapShouldBeEmpty() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        greet.clearMap();
        //System.out.println(greet.counter());
        assertEquals("the size of the map is 0", greet.counter());
    }

    @Test
    public void shouldReturnAllCommands() {
        Greet greet = new Greet("sandman", Language.xhosa);

        assertEquals("Valid commands are:\ngreet\ngreeted\ncounter\nclear\nhelp\nexit", greet.help());
    }
}
