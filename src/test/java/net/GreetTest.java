package net;

import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;

//import static Language.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void shouldReturnGreeting() {
        Greet greet = new Greet("sandiso", Language.english);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("Hallo me", greet.greet("me", "Afrikaans"));
    }
    @Test
    public void shouldReturnGreetedUserNames() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("{anotherme=1, me=1, sandman=1, sandiso=2}", greet.greeted().toString());
    }

    @Test
    public void shouldReturnNumOfTimesUserNameGreetd() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");


        assertEquals("user name sandiso was greeted 2 time(s)", greet.greeted("sandiso"));
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
    public void shouldRemoveUserName() {
        Greet greet = new Greet("sandiso", Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        greet.clearUserName("sandiso");
        assertEquals("{anotherme=1, me=1, sandman=1}", greet.greeted().toString());
    }

    @Test
    public void shouldReturnAllCommands() {
        Greet greet = new Greet("sandman", Language.xhosa);

        assertEquals("Valid commands are:\ngreet\ngreeted\ncounter\nclear\nhelp\nexit\n", greet.help());
    }
}
