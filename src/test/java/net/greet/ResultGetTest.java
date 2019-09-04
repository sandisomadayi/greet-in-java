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
    void shouldDisplayMessageWhenClearingName() {
        Greeting greeting = new JDBCGreet();
        AcceptCommands acceptCommands = new AcceptCommands("clear me");
        Processor processor = new Processor(greeting);
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals("me deleted!", resultGet.getMessage());
    }

    @Test
    void shouldDisplayStatusWhenInvalidCommandEntered() {
        Greeting greeting = new JDBCGreet();
        AcceptCommands acceptCommands = new AcceptCommands("fgjfsdlksjkgl jklfdjlkgsl glskjlkf jfallf jflaflk jlafjlasd");
        Processor processor = new Processor(greeting);
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals(true, resultGet.getMenuStatus());
    }
    @Test
    void shouldDisplayMessageWhenInvalidCommandEntered() {
        Greeting greeting = new JDBCGreet();
        AcceptCommands acceptCommands = new AcceptCommands("fgjfsdlksjkgl jklfdjlkgsl glskjlkf jfallf jflaflk jlafjlasd");
        Processor processor = new Processor(greeting);
        ResultGet resultGet = new ResultGet(processor.processCommands(acceptCommands));

        assertEquals("Command entered not valid!\n" +
                "Valid commands are:\n" +
                "greet - with a name will greet the person in a specified language\n" +
                "greeted - shows how many times a person was greeted\n" +
                "count - shows how many people were greeted\n" +
                "clear - deletes a name or all names that were greeted\n" +
                "help - displays commands to use\n" +
                "exit - exits the application", resultGet.getMessage());
    }
}
