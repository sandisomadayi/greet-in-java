package net.greet;

import org.junit.jupiter.api.Test;

public class ProcessorTest {

    @Test
    void shouldGreetUser() {
        AcceptCommands acceptCommands = new AcceptCommands("count");
        Greeting greeting = new Greet();
        JDBCGreet jdbcGreet = new JDBCGreet();
        Processor processor = new Processor(greeting, jdbcGreet);

        System.out.println(processor.processCommands(acceptCommands));
    }
}
