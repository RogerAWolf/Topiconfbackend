package nl.topicus.topiconfbackend.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenementUT {

    private Evenement evenement;

    // This constructor is invoked every time @Test annotated method is run
    public EvenementUT() {
        this.evenement = new Evenement();
    }

    @Test
    public void testGetAndSetId() {
        evenement.setId(30L);
        assertEquals(30L, evenement.getId());
    }

    @Test
    public void testGetAndSetNaam() {
        evenement.setNaam("Rudiger");
        assertEquals("Rudiger", evenement.getNaam());
    }

    @Test
    public void testGetAndSetOmschrijving() {
        evenement.setOmschrijving("Tropisch paradijs voor iedereen");
        assertEquals("Tropisch paradijs voor iedereen", evenement.getOmschrijving());
    }

    @Test
    public void testGetAndSetBeginDatumTijd() {
        LocalDateTime now = LocalDateTime.now();
        evenement.setBeginDatumTijd(now);
        assertEquals(now, evenement.getBeginDatumTijd());
    }

    @Test
    public void testGetAndSetEindDatumTijd() {
        LocalDateTime now = LocalDateTime.now();
        evenement.setEindDatumTijd(now);
        assertEquals(now, evenement.getEindDatumTijd());
    }

    @Test
    public void testGetAndSetTrackList() {
        List<Track> testTrackList = new ArrayList<>();
        Track testTrack = new Track();
        testTrackList.add(testTrack);

        evenement.setTrackList(testTrackList);
        assertEquals(testTrackList, evenement.getTrackList());
    }

    @Test
    public void testGetAndSetAanvraagList() {
        List<Voorstel> testAanvraagList = new ArrayList<>();
        Voorstel testAanvraag = new Voorstel();
        testAanvraagList.add(testAanvraag);

        evenement.setVoorstelList(testAanvraagList);
        assertEquals(testAanvraagList, evenement.getVoorstelList());
    }
}