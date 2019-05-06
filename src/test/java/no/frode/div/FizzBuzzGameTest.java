package no.frode.div;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzGameTest {

    FizzBuzzGame fbg = new FizzBuzzGame();

    @Test
    public void skal_gi_1() {
        String retVal = fbg.fizzBuzzGame(1);
        assertEquals("1", retVal);
    }

    @Test
    public void skal_gi_fizz() {
        String retVal = fbg.fizzBuzzGame(3);
        assertEquals("fizz", retVal);
    }

    @Test
    public void skal_gi_buzz() {
        String retVal = fbg.fizzBuzzGame(5);
        assertEquals("buzz", retVal);
    }

    @Test
    public void skal_gi_14() {
        String retVal = fbg.fizzBuzzGame(14);
        assertEquals("14", retVal);
    }

    @Test
    public void skal_fizzbuzz() {
        String retVal = fbg.fizzBuzzGame(15);
        assertEquals("fizzbuzz", retVal);
    }
}
