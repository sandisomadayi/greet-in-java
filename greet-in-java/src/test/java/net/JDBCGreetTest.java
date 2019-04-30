package net;

import net.greet.JDBCGreet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCGreetTest {


    @Test
    public void shouldAddAndGreetPerson() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("Molo, sandman", jdbcGreet.greet("sandman", "xhosa"));
    }

    @Test
    public void userNameGreetCount() {
        JDBCGreet jdbcGreet = new JDBCGreet();


        assertEquals("{me=1, sandman=5, him=1}", jdbcGreet.greeted(null));
    }

    @Test
    public void tableSize() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("names greeted: 2", jdbcGreet.counter());
    }

    @Test
    public void shouldClearNameOrTable() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("All names deleted!", jdbcGreet.clear(null));
    }
}
