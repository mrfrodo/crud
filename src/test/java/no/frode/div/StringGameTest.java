package no.frode.div;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringGameTest {

    StringGame game = new StringGame();

    @Test
    public void findLowest() {
        String actual = game.getLowestNumber();

        assertEquals("1", actual );
    }

    @Test
    public void findStartsWitha() {
        String actual = game.getStartsWitha();

        assertEquals("A1,A2,A99,", actual );
    }

    @Test
    public void findLowestByList() {
        String[] stringsAsArray = {"1", "2", "6", "8", "3", "0"};

        String actual = game.getLowestNumberByArray(stringsAsArray);

        assertEquals("0", actual );
    }

    @Test
    public void findHighestByList() {
        String[] stringsAsArray = {"1", "2", "6", "8", "3", "0"};

        String actual = game.getHighestNumberByArray(stringsAsArray);

        assertEquals("8", actual );
    }
}
