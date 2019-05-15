package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {
    @BeforeEach
    public void shouldClearAllAndAddNames() {
        Greeting greeting = new JDBCGreet();
        greeting.clear(null);
        greeting.greet("sandiso", "xhosa");
        greeting.greet("sandman", "venda");
        greeting.greet("madayi", "tsonga");
    }

    @Test
    void shouldDisplayNumberOfGreetedUsers() {
        AcceptCommands acceptCommands = new AcceptCommands("count");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("names greeted: 3", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldDisplayExitMessage() {
        AcceptCommands acceptCommands = new AcceptCommands("exit");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("Good bye", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldDisplayGreetedUsers() {
        AcceptCommands acceptCommands = new AcceptCommands("greeted");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("{madayi=1, sandman=1, sandiso=1}", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldDeleteAllNames() {
        AcceptCommands acceptCommands = new AcceptCommands("clear");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("All names deleted!", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldDeleteNameSpecified() {
        AcceptCommands acceptCommands = new AcceptCommands("clear sandiso");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("sandiso deleted!", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldSayNameNotGreeted() {
        AcceptCommands acceptCommands = new AcceptCommands("greeted Babs");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("babs has not been greeted, try greeting it first.", processor.processCommands(acceptCommands));
    }

    @Test
    void shouldShowGreetedNames() {
        AcceptCommands acceptCommands = new AcceptCommands("clear Babs");
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);

        assertEquals("babs has not been greeted, try greeting it first.", processor.processCommands(acceptCommands));
    }
}