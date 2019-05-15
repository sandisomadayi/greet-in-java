package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void shouldReturnGreeting() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("Hallo, me", greet.greet("me", "Afrikaans"));
    }
    @Test
    public void shouldReturnGreetedUserNames() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("{anotherme=1, me=1, sandman=1, sandiso=2}", greet.greeted(""));
    }

    @Test
    public void shouldReturnNumOfTimesUserNameGreetd() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");


        assertEquals("sandiso was greeted 2 time(s)", greet.greeted("sandiso"));
    }

    @Test
    public void shouldCountUserNames() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");


        assertEquals("name(s) greeted: 4", greet.counter());
    }

    @Test
    public void allNamesMustBeDeleted() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("All names deleted.", greet.clear(""));
    }

    @Test
    public void shouldRemoveUserName() {
        Greet greet = new Greet();

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        assertEquals("sandiso deleted.", greet.clear("sandiso"));
    }

    @Test
    public void shouldReturnAllCommands() {
        Greet greet = new Greet();

        assertEquals("Valid commands are:\ngreet - with a name will greet the person in a specified language\ngreeted - shows how many times a person was greeted\ncount - shows how many people were greeted\nclear - deletes a name or all names that were greeted\nhelp - displays commands to use\nexit - exits the application", greet.help());
    }
}
