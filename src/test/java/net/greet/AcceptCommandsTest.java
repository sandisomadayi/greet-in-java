package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptCommandsTest {

    @Test
    void shouldDisplayUserName() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso venda");

        assertEquals("sandiso", acceptCommands.getUserName());
    }

    @Test
    void shouldDisplayCommand() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso venda");

        assertEquals("greet", acceptCommands.getCommand());
    }

    @Test
    void shouldDisplayDefaultLanguage() {
        AcceptCommands acceptCommands = new AcceptCommands("greet sandiso");

        assertEquals("english", acceptCommands.getLanguage());
    }

    @Test
    void shouldDisplayEnteredLanguage() {
        AcceptCommands acceptCommands = new AcceptCommands("greet mafalala venda");

        assertEquals("venda", acceptCommands.getLanguage());
    }
}
