package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocatieServiceIT {

    @InjectMocks
    private LocatieService locatieService;

    @Mock
    private LocatieRepository locatieRepository;

    // Constructor
    public LocatieServiceIT() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGeefAlleLocaties() {
        // To be programmed
    }

    @Test
    public void testSlaLocatieOp() {
        // To be programmed
    }

    @ParameterizedTest
    @ValueSource(longs = -10L)
    public void testVerwijderLocatie(long locatieID) {

        // When
        Boolean isVerwijderd = this.locatieService.verwijderLocatie(locatieID);

        // in case given ID parameter is a negative value then
        assertEquals(isVerwijderd, false);
        // in case ID can't be found at all then
        assertEquals(locatieService.verwijderLocatie(15L), false);
        // in case ID is found and record is removed then
        Mockito.when(this.locatieService.verwijderLocatie(-10L)).thenReturn(true);
    }

    @Test
    public void testFindById() {

        // Given
        Locatie mockedLocatie = new Locatie();
        mockedLocatie.setId(1L);
        mockedLocatie.setName("Tropicana");
        mockedLocatie.setDescription("Een mooie rustgevende locatie");
        mockedLocatie.setCapacity("100 Personen");

        Optional<Locatie> myLocatie = Optional.of(mockedLocatie);

        Mockito.when(this.locatieRepository.findById(1L)).thenReturn(myLocatie);

        // When
        Locatie locatieFromService = this.locatieService.findById(1L);

        // Then
        assertNotNull(locatieFromService);
        assertEquals(1L, locatieFromService.getId());
        assertEquals("Tropicana", locatieFromService.getName());
        assertEquals("Een mooie rustgevende locatie", locatieFromService.getDescription());
        assertEquals("100 Personen", locatieFromService.getCapacity());

    }
}