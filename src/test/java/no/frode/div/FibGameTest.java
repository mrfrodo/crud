package no.frode.div;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibGameTest {

    FibGame fg = new FibGame();

    @Test
    public void tell_10_første_fib() {
        String retVal = fg.fib(10);
        assertEquals("0 1 1 2 3 5 8 13 21 34 ", retVal);
    }

    @Test
    public void tell_5_første_fib() {
        String retVal = fg.fib(5);
        assertEquals("0 1 1 2 3 ", retVal);
    }
}
