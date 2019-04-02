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

        //greet.greet("d", Language.Xhosa);
        //System.out.println(greet.greet("sandiso", Language.Xhosa));
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
        assertEquals("{anotherMe=1, me=1, sandman=1, sandiso=2}", greet.greeted().toString());
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

        greet.clearMap();
        //System.out.println(greet.counter());
        assertEquals(0, greet.counter());
    }
}
