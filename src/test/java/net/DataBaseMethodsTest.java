package net;

import net.greet.DataBaseMethods;
import net.greet.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataBaseMethodsTest {
    @Test
    public void shouldAddName() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        assertEquals("Hello sandman",dataBaseMethods.greet("sandman", null));
    }

    @Test
    public void userNameGreetCount() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        assertEquals(0, dataBaseMethods.greeted("madayi"));
    }

    @Test
    public void shouldClearName() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        dataBaseMethods.clear(null);
    }
}
