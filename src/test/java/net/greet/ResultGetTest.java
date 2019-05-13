package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultGetTest {

    @Test
    void shouldDisplayMessage() {
        Greeting greeting = new JDBCGreet();
        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);
        AcceptCommands acceptCommands = new AcceptCommands("exit me again");
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));
        assertEquals("Good bye", resultGet.getMessage());
    }
    @Test
    void shouldDisplayStatus() {
        Greeting greeting = new JDBCGreet();
        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);
        AcceptCommands acceptCommands = new AcceptCommands("exit me again");
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));
        assertEquals(false,resultGet.getMenuStatus());
    }
}
