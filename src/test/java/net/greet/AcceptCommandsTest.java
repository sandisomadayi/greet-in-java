package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptCommandsTest {

    @Test
    void shouldGetUserName() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso venda");

        assertEquals("sandiso", acceptCommands.getUserName());
    }

    @Test
    void shouldGetGreetCommand() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso venda");

        assertEquals("greet", acceptCommands.getCommand());
    }

    @Test
    void shouldGetLanguage() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso venda");

        assertEquals("venda", acceptCommands.getLanguage());
    }
    
    @Test
    void shouldGetGreetedCommand() {
        AcceptCommands acceptCommands = new AcceptCommands("greeted");
        
        assertEquals("greeted", acceptCommands.getCommand());
    }
}
