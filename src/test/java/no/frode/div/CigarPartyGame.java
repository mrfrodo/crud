package no.frode.div;

public class CigarPartyGame {

    public boolean cigarParty(int cigars, boolean isWeeking) {

        if (cigars >=40 && isWeeking) {
            return true;

        }

        if (cigars >=40 && cigars <= 60) {
            return true;
        }

        return false;
    }


}
