package no.frode.div;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CigarPartyGameTest {

    CigarPartyGame cgg = new CigarPartyGame();

    @Test
    public void ikke_party_med_30_sigarer_i_ukedag() {
        boolean party = cgg.cigarParty(30, false);

        assertFalse(party);
    }

    @Test
    public void party_med_50_sigarer_i_ukedag() {
        boolean party = cgg.cigarParty(50, false);

        assertTrue(party);
    }

    @Test
    public void ikke_party_med_10_sigarer_i_ukedag() {
        boolean party = cgg.cigarParty(10, false);

        assertFalse(party);
    }

    @Test
    public void ikke_party_med_70_sigarer_i_ukedag() {
        boolean party = cgg.cigarParty(70, false);

        assertFalse(party);
    }

    @Test
    public void party_med_70_sigarer_i_helga() {
        boolean party = cgg.cigarParty(70, true);

        assertTrue(party);
    }
}
