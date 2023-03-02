package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testVerweijderLocatie() {
        // To be programmed
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