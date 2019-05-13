package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {

    @Test
    void shouldDisplayNumberOfGreetedUsers() {
        AcceptCommands acceptCommands = new AcceptCommands("count");
        Greeting greeting = new Greet();
        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);

        assertEquals("names greeted: 3", processor.processCommands(acceptCommands));
    }
}
