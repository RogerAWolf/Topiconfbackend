package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocatieServiceIT {

    @InjectMocks
    private LocatieService locatieService;

    @Mock
    private LocatieRepository locatieRepository;
    private static final Locatie mockedLocatie1;
    private static final Locatie mockedLocatie2;
    private static final Optional<Locatie> myLocatie1;
    private static final ArrayList<Locatie> locatieLijst;

    // Constructor
    public LocatieServiceIT() {

        MockitoAnnotations.openMocks(this);

    }
    static {
        mockedLocatie1 = new Locatie();
        mockedLocatie1.setId(1L);
        mockedLocatie1.setName("Tropicana");
        mockedLocatie1.setDescription("Een mooie rustgevende locatie");
        mockedLocatie1.setCapacity("100 Personen");

        myLocatie1 = Optional.of(mockedLocatie1);

        mockedLocatie2 = new Locatie();
        mockedLocatie2.setId(2L);
        mockedLocatie2.setName("Plopsaland");
        mockedLocatie2.setDescription("Een bos vol met kabouters");
        mockedLocatie2.setCapacity("2000 Personen");

        locatieLijst = new ArrayList<Locatie>();
        locatieLijst.add(mockedLocatie1);
        locatieLijst.add(mockedLocatie2);
    }

    @Test
    public void testGeefAlleLocaties() {

        // Given
        Mockito.when(this.locatieRepository.findAll()).thenReturn(this.locatieLijst);

        // When
        Iterable<Locatie> locatieLijstFromService = this.locatieService.geefAlleLocaties();

        // Then
        assertNotNull(locatieLijstFromService);

        int i = 0;
        long x = 1L;
        for (Locatie locatie : locatieLijst) {
            if( i == 0 ) {

                assertEquals(x, locatieLijst.get(i).getId());
                assertEquals("Tropicana", locatieLijst.get(i).getName());
                assertEquals("Een mooie rustgevende locatie", locatieLijst.get(i).getDescription());
                assertEquals("100 Personen", locatieLijst.get(i).getCapacity());
                i++;
                x++;

            } else if( i == 1 ) {

                assertEquals(x, locatieLijst.get(i).getId());
                assertEquals("Plopsaland", locatieLijst.get(i).getName());
                assertEquals("Een bos vol met kabouters", locatieLijst.get(i).getDescription());
                assertEquals("2000 Personen", locatieLijst.get(i).getCapacity());

            }
        }
    }

    @ParameterizedTest
    @MethodSource
    public void testSlaLocatieOp(Locatie locatie) {

        assertNotNull(locatie);
        assertEquals(true , locatieService.slaLocatieOp(locatie));
        assertEquals(false, locatieService.slaLocatieOp(null) );

    }

    private static Stream<Locatie> testSlaLocatieOp() {
        return Stream.of(mockedLocatie1);
    }

//    INFO:
//    Example of how to test a method with Object parameter
//    @ParameterizedTest
//    @MethodSource     /* When we don't provide a name for the @MethodSource, JUnit will search for
//                      a source method with the same name as the test method */
//    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
//        assertTrue(Strings.isBlank(input));
//    }
//
//    private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
//        return Stream.of(null, "", "  ");
//    }

    @ParameterizedTest
    @ValueSource(longs = -10L)
    public void testVerwijderLocatie(long locatieID) {

        // Given
        // locatieID = -10L

        // When
        Boolean isVerwijderd = this.locatieService.verwijderLocatie(locatieID);

        // Then
        // in case given ID parameter is a negative value then
        assertEquals(isVerwijderd, false);
        // in case ID can't be found at all then
        assertEquals(this.locatieService.verwijderLocatie(15L), false);
        // in case ID is found and record is removed then
        Mockito.when(this.locatieService.verwijderLocatie(-10L)).thenReturn(true);

    }

    @ParameterizedTest
    @ValueSource(longs = 1L)
    public void testFindById(long locatieid) {

        // Given
        Mockito.when(this.locatieRepository.findById(locatieid)).thenReturn(this.myLocatie1);

        // When
        Locatie locatieFromService = this.locatieService.findById(locatieid);

        // Then
        assertNotNull(locatieFromService);
        assertEquals(locatieid, locatieFromService.getId());
        assertEquals("Tropicana", locatieFromService.getName());
        assertEquals("Een mooie rustgevende locatie", locatieFromService.getDescription());
        assertEquals("100 Personen", locatieFromService.getCapacity());

    }
}