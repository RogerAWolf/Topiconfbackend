package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocatieServiceIT {

    @InjectMocks
    private LocatieService locatieService;

    @Mock
    private LocatieRepository locatieRepository;
    private final Locatie mockedLocatie1;
    private final Locatie mockedLocatie2;
    private final Optional<Locatie> myLocatie1;
    private final Optional<Locatie> myLocatie2;
    private final ArrayList<Locatie> locatieLijst;

    // Constructor
    public LocatieServiceIT() {
        MockitoAnnotations.openMocks(this);

        this.mockedLocatie1 = new Locatie();
        this.mockedLocatie1.setId(1L);
        this.mockedLocatie1.setName("Tropicana");
        this.mockedLocatie1.setDescription("Een mooie rustgevende locatie");
        this.mockedLocatie1.setCapacity("100 Personen");

        this.myLocatie1 = Optional.of(mockedLocatie1);

        this.mockedLocatie2 = new Locatie();
        this.mockedLocatie2.setId(1L);
        this.mockedLocatie2.setName("Tropicana");
        this.mockedLocatie2.setDescription("Een mooie rustgevende locatie");
        this.mockedLocatie2.setCapacity("100 Personen");

        this.myLocatie2 = Optional.of(mockedLocatie2);

        this.locatieLijst = new ArrayList<Locatie>();
        this.locatieLijst.add(mockedLocatie1);
        this.locatieLijst.add(mockedLocatie2);

    }

    @Test
    public void testGeefAlleLocaties() {

        // Given
        Mockito.when(this.locatieRepository.findAll()).thenReturn(this.locatieLijst);

        // When
        Iterable<Locatie> locatieLijstFromService = this.locatieService.geefAlleLocaties();

        // Then
        assertNotNull(locatieLijstFromService);

        for (Locatie locatie : locatieLijst) {

        }

    }

    @Test
    public void testSlaLocatieOp() {
        // Empty
    }

    @ParameterizedTest
    @ValueSource(longs = -10L)
    public void testVerwijderLocatie(long locatieID) {

        // Given
        // locatieID = -10L

        // When
        Boolean isVerwijderd = this.locatieService.verwijderLocatie(locatieID);

        // in case given ID parameter is a negative value then
        assertEquals(isVerwijderd, false);
        // in case ID can't be found at all then
        assertEquals(this.locatieService.verwijderLocatie(15L), false);
        // in case ID is found and record is removed then
        Mockito.when(this.locatieService.verwijderLocatie(-10L)).thenReturn(true);
    }

    @Test
    public void testFindById() {

        // Given
        Mockito.when(this.locatieRepository.findById(1L)).thenReturn(this.myLocatie1);

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