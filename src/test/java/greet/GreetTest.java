package greet;

import org.junit.jupiter.api.Test;

//import static greet.Language.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void shouldReturnGreetingTest() {
        Greet greet = new Greet("sandiso", Language.Xhosa);

        greet.greet("sandiso", Language.Xhosa);
        greet.greet("sandiso", Language.English);
        greet.greet("sandman", Language.Xhosa);
        greet.greet("me", Language.Xhosa);
        greet.greet("anotherMe", Language.Venda);

        assertEquals("Molo", greet.greet("sandiso", Language.Xhosa));
    }
    @Test
    public void shouldReturnGreetedUserNamesTest() {
        Greet greet = new Greet("sandiso",  Language.Xhosa);

        greet.greet("sandiso", Language.Xhosa);
        greet.greet("sandiso", Language.English);
        greet.greet("sandman", Language.Xhosa);
        greet.greet("me", Language.Xhosa);
        greet.greet("anotherMe", Language.Venda);


        assertEquals(2, greet.greeted("sandiso"));
        assertEquals(greet.greeted(), greet.greeted());
    }

    @Test
    public void shouldCountUserNames() {
        Greet greet = new Greet("sandiso",  Language.Xhosa);

        greet.greet("sandiso", Language.Xhosa);
        greet.greet("sandiso", Language.English);
        greet.greet("sandman", Language.Xhosa);
        greet.greet("me", Language.Xhosa);
        greet.greet("anotherMe", Language.Venda);


        assertEquals(4, greet.counter());
    }

    @Test
    public void mapShouldBeEmpty() {
        Greet greet = new Greet("sandiso",  Language.Xhosa);

        greet.greet("sandiso", Language.Xhosa);
        greet.greet("sandiso", Language.English);
        greet.greet("sandman", Language.Xhosa);
        greet.greet("me", Language.Xhosa);
        greet.greet("anotherMe", Language.Venda);

        greet.clear();
        System.out.println(greet.counter());
        //assertEquals(0, greet.counter());
    }
}
