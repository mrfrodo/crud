package no.frode.div;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    BlackJackGame bjg = new BlackJackGame();

    @Test
    public void testBlackJack() {

        String retVal = bjg.blackJack(19, 21);

        assertEquals("21", retVal);
    }

    @Test
    public void testBlackJack2() {

        String retVal = bjg.blackJack(21, 19);

        assertEquals("21", retVal);
    }

    @Test
    public void testBlackJack3() {

        String retVal = bjg.blackJack(21, 22);

        assertEquals("21", retVal);
    }

    @Test
    public void testBlackJack4() {

        String retVal = bjg.blackJack(22, 21);

        assertEquals("21", retVal);
    }

    @Test
    public void testBlackJack5() {

        String retVal = bjg.blackJack(2, 3);

        assertEquals("3", retVal);

    }
}
