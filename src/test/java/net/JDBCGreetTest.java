package net;

import net.greet.JDBCGreet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCGreetTest {
//    @BeforeEach

    @Test
    public void shouldAddAndGreetPerson() {
        JDBCGreet JDBCGreet = new JDBCGreet();

        assertEquals("Molo, sandman", JDBCGreet.greet("sandman", "xhosa"));
    }

    @Test
    public void userNameGreetCount() {
        JDBCGreet JDBCGreet = new JDBCGreet();


        assertEquals("{sandman=18,him=1}", JDBCGreet.greeted(null));
    }

    @Test
    public void tableSize() {
        JDBCGreet JDBCGreet = new JDBCGreet();


//        System.out.println(JDBCGreet.count());
        assertEquals(1, JDBCGreet.count(null));
    }

    @Test
    public void shouldClearNameOrTable() {
        JDBCGreet JDBCGreet = new JDBCGreet();


        assertEquals("", JDBCGreet.clear(null));
    }
}
