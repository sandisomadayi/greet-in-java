package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultGetTest {

    @Test
    void shouldDisplayMessage() {
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);
        AcceptCommands acceptCommands = new AcceptCommands("exit");
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals("Good bye", resultGet.getMessage());
    }
    @Test
    void shouldDisplayStatus() {
        Greeting greeting = new JDBCGreet();
        Processor processor = new Processor(greeting);
        AcceptCommands acceptCommands = new AcceptCommands("exit                                ");
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals(false, resultGet.getMenuStatus());
    }

    @Test
    void shouldDisplayMessage2() {
        Greeting greeting = new JDBCGreet();
        AcceptCommands acceptCommands = new AcceptCommands("clear me");
        Processor processor = new Processor(greeting);
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals("me has not been greeted, try greeting it first.", resultGet.getMessage());
    }

    @Test
    void shouldDisplayStatus2() {
        Greeting greeting = new JDBCGreet();
        AcceptCommands acceptCommands = new AcceptCommands("fgjfsdlksjkgl jklfdjlkgsl glskjlkf jfallf jflaflk jlafjlasd");
        Processor processor = new Processor(greeting);
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals(true, resultGet.getMenuStatus());
    }
}
