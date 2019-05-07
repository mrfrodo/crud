package no.frode.div;

public class BlackJackGame {

    public String blackJack(int i, int j) {

        int absi = (21 - i);
        int absj = (21 - j);

        if (absj < 0) {
            return String.valueOf(i);
        }

        if (absi < 0) {
            return String.valueOf(j);
        }

        if (absj < absi) {
            return String.valueOf(j);
        } else {
            return String.valueOf(i);
        }


    }
}
