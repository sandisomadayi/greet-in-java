package net;

import net.greet.JDBCGreet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCGreetTest {


    @Test
    public void shouldAddAndGreetPerson() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("Molo, me", jdbcGreet.greet("me", "xhosa"));
    }

    @Test
    public void userNameGreetCount() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("{her=1, me=1, sandman=2, them=1, him=1, sandiso=1}", jdbcGreet.greeted(null));
    }

    @Test
    public void tableSize() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        jdbcGreet.greeted(null);
        assertEquals("names greeted: 2", jdbcGreet.counter());
    }

    @Test
    public void shouldClearNameOrTable() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("All names deleted!", jdbcGreet.clear("me"));
    }
}
