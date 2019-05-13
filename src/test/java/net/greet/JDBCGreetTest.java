package net.greet;

import net.greet.JDBCGreet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCGreetTest {
    @BeforeEach
    public void clearAllAndAddNames() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        jdbcGreet.clear(null);
        jdbcGreet.greet("sandiso", "xhosa");
        jdbcGreet.greet("sandman", "venda");
        jdbcGreet.greet("madayi", "tsonga");
    }

    @Test
    public void shouldAddAndGreetPerson() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("Molo, madayi", jdbcGreet.greet("madayi", "xhosa"));
    }

    @Test
    public void shouldReturnAllGreetedUsers() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("{madayi=1, sandman=1, sandiso=1}", jdbcGreet.greeted(null));
    }

    @Test
    public void shouldShowHowManyTimesUserWasGreeted() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("madayi has been greeted 1 time(s)", jdbcGreet.greeted("madayi"));
    }

    @Test
    public void shouldReturnNumberOfNamesGreeted() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        jdbcGreet.greeted(null);
        assertEquals("names greeted: 3", jdbcGreet.counter());
    }

    @Test
    public void shouldDeleteAllNames() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("All names deleted!", jdbcGreet.clear(null));
    }

    @Test
    public void shouldClearName() {
        JDBCGreet jdbcGreet = new JDBCGreet();

        assertEquals("madayi deleted!", jdbcGreet.clear("madayi"));
    }
}