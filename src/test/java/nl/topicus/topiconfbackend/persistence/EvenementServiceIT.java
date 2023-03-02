package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Track;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EvenementServiceIT {

    @InjectMocks
    private EvenementService evenementService;

    @Mock
    private EvenementRepository evenementRepository;

    // Constructor
    public EvenementServiceIT() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGeefAlleEvenementen() {
        // To be programmed
    }

    @Test
    public void testSlaEvenementOp(Evenement evenement) {
        // To be programmed
    }

    @Test
    public void testGeefAlleAanvragen(Evenement evenement) {
        // To be programmed
    }

    @Test
    public void testGeefTracksPerEvenement(Evenement evenement) {
        // To be programmed
    }

    @Test
    public void testGeefLocatiesPerEvenement(Evenement evenement) {
        // To be programmed
    }

    @Test
    public void testVerwijderEvenement(long eventID) {
        // To be programmed
    }

    @Test
    public void testfindById(long eventID) {
        // To be programmed
    }

    @Test
    public void testSlaEventEnTrackOp(Evenement evenement, Track track) {
        // To be programmed
    }

    @Test
    public void testSlaEventEnLocatieOp(Evenement evenemeny, Locatie locatie) {
        // To be programmed
    }
}
