package net;

import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static java.lang.Class.forName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

        assertEquals("{anotherme=1, me=1, sandman=1, sandiso=2}", greet.greeted(null).toString());
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


        assertEquals("number of name(s) greeted 4", greet.counter());
    }

    @Test
    public void mapShouldBeEmpty() {
        Greet greet = new Greet("sandiso",  Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        greet.clear(null);
        //System.out.println(greet.counter());
        assertEquals("number of name(s) greeted 0", greet.counter());
    }

    @Test
    public void shouldRemoveUserName() {
        Greet greet = new Greet("sandiso", Language.xhosa);

        greet.greet("SANDISO", "xhosa");
        greet.greet("sandiso", "english");
        greet.greet("sandman", "xhosa");
        greet.greet("me", "Xhosa");
        greet.greet("anotherMe", "Venda");

        greet.clear("sandiso");
        assertEquals("{anotherme=1, me=1, sandman=1}", greet.greeted(null).toString());
    }

    @Test
    public void shouldReturnAllCommands() {
        Greet greet = new Greet("sandman", Language.xhosa);

        assertEquals("Valid commands are:\ngreet\ngreeted\ncount\nclear\nhelp\nexit\n", greet.help());
    }

    final String DATABASE_LINK = "jdbc:h2:./target/userNames_db";
    @Test
    public void someMethod() {
        Greet greet = new Greet("name", Language.xhosa);
        try {
            forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_LINK);

            Statement statement = connection.createStatement();
            final String INSERT_NAME = "insert into people (name) values (?)";

            PreparedStatement addName = connection.prepareStatement(INSERT_NAME);

            addName.setString(1, "sandiso");
            addName.execute();
            addName.setString(1, "me");
            addName.execute();

            ResultSet res = connection.createStatement().executeQuery("select * from people w");
        }
        catch (Exception e) {
            fail(e);
        }
    }

//    @Test
//    public void shouldAddNames() {
//
//    }
}
