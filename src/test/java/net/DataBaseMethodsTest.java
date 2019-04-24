package net;

import net.greet.DataBaseMethods;
import net.greet.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataBaseMethodsTest {
    @BeforeEach

    @Test
    public void shouldAddAndGreetPerson() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        assertEquals("Hello, sandman",dataBaseMethods.greet("sandman", null));
    }

    @Test
    public void userNameGreetCount() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        assertEquals(5, dataBaseMethods.greeted("sandman"));
    }

    @Test
    public void tableSize() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        System.out.println(dataBaseMethods.count());
        assertEquals(1, dataBaseMethods.count());
    }

    @Test
    public void shouldClearNameOrTable() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        dataBaseMethods.clear(null);
    }

    @Test
    public void shouldReturnTable() {
        DataBaseMethods dataBaseMethods = new DataBaseMethods();

        dataBaseMethods.greetingsDB();
        System.out.println(dataBaseMethods.table());
    }
}
