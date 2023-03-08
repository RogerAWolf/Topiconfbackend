package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.domain.Voorstel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EvenementServiceIT {

    private LocalDateTime mockedDateTime;
    private List<Categorie> mockedCategorieList;
    private List<Voorstel> mockedAanvraagList;

    @InjectMocks
    private EvenementService evenementService;

    @Mock
    private EvenementRepository evenementRepository;

    // Constructor
    public EvenementServiceIT() {
        MockitoAnnotations.openMocks(this);
        mockedDateTime = LocalDateTime.now();
        mockedCategorieList = new ArrayList<>();
        mockedAanvraagList = new ArrayList<>();
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

    @ParameterizedTest
    @ValueSource(longs = 1L)
    public void testfindById(long eventID) {

        // Given
        Evenement mockedEvenement = new Evenement();
        mockedEvenement.setId(eventID);
        mockedEvenement.setNaam("Jan Smit");
        mockedEvenement.setOmschrijving("Ongetwijfeld Nederlands beste volkszanger");
        mockedEvenement.setBeginDatumTijd(mockedDateTime);
        mockedEvenement.setEindDatumTijd(mockedDateTime);
        mockedEvenement.setTrackLijst(mockedCategorieList);
        mockedEvenement.setVoorstelLijst(mockedAanvraagList);

        Optional<Evenement> myEvenement = Optional.of(mockedEvenement);

        Mockito.when(this.evenementRepository.findById(eventID)).thenReturn(myEvenement);

        // When
        Evenement evenementFromService = this.evenementService.findById(eventID);

        // Then
        assertNotNull(evenementFromService);
        assertEquals(1L, evenementFromService.getId());
        assertEquals("Jan Smit", evenementFromService.getNaam());
        assertEquals("Ongetwijfeld Nederlands beste volkszanger", evenementFromService.getOmschrijving());
        assertEquals(mockedDateTime , evenementFromService.getBeginDatumTijd());
        assertEquals(mockedDateTime, evenementFromService.getEindDatumTijd());
        assertEquals(mockedCategorieList, evenementFromService.getTrackLijst());
        //assertEquals(mockedAanvraagList, evenementFromService.setLocatieLijst());  // <- moet nog gemaakt worden (parameter
                                                                                     // ontbreekt na aanpassing in de klasse zelf)

    }

    @Test
    public void testSlaEventEnTrackOp(Evenement evenement, Categorie categorie) {
        // To be programmed
    }

    @Test
    public void testSlaEventEnLocatieOp(Evenement evenemeny, Locatie locatie) {
        // To be programmed
    }
}
