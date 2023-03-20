package nl.topicus.topiconfbackend.persistence;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import nl.topicus.topiconfbackend.domain.Persoon;


public class PersoonServiceIT {
	
	// Deze variabelen worden gebruikt om de te testen objecten en data bij te houden.
	@Mock
	private PersoonRepository persoonRep;
	private static final Persoon mockedPersoon1;
	private static final Persoon mockedPersoon2;
	private static final Optional<Persoon> myPersoon;
	private static final ArrayList<Persoon> persoonLijst;
	
	// Dit injecteert de mock-objecten in de serviceklasse.
	@InjectMocks
	private PersoonService persoonService;
	
	// Dit is de constructor, die de mock-objecten initialiseert.
	public PersoonServiceIT() {
		
		MockitoAnnotations.openMocks(this);
	}
	
	// Hier maken we 2x een mockedPersoon om te gebruiken in de testen
	static {
		mockedPersoon1 = new Persoon();
		mockedPersoon1.setId(1L);
		mockedPersoon1.setVoornaam("Henk");
		mockedPersoon1.setAchternaam("Jansen");
		mockedPersoon1.setEmail("henk.jansen@example.com");
		mockedPersoon1.setRol("Organisator");
		
		myPersoon= Optional.of(mockedPersoon1);
		
		mockedPersoon2 = new Persoon();
		mockedPersoon2.setId(2L);
		mockedPersoon2.setVoornaam("Karel");
		mockedPersoon2.setAchternaam("de Grote");
		mockedPersoon2.setEmail("karel.de.grote@example.com");
		mockedPersoon2.setRol("Spreker");
		
		persoonLijst = new ArrayList<Persoon>();
		persoonLijst.add(mockedPersoon1);
		persoonLijst.add(mockedPersoon2);
	}
	
	
	// Deze methode test of een persoon correct wordt opgeslagen aan de database.
	@ParameterizedTest
	@MethodSource
	public void testToevoegenPersoon(Persoon persoon) {
		//assert om te Controleren of het opslaan van een persoon correct werkt
		assertNotNull(persoon);
		assertEquals(true, persoonService.slaPersoonOp(persoon));
		assertEquals(false, persoonService.slaPersoonOp(null));
	}
	
	// Deze methode test of alle personen in de database correct worden opgehaald.
	@Test
	public void testBekijkPersoon() {
		
		//Given
		// Mocking van de findAll() methode van de PersoonRepository
		Mockito.when(this.persoonRep.findAll()).thenReturn(this.persoonLijst);
		
		//When
		// Ophalen van de Persoon objecten via de PersoonService
		Iterable<Persoon> persoonLijstFromService = ((PersoonService) this.persoonRep).geefAllePersonen();
		
		//Then
		// Asserts om te controleren of de opgehaalde Persoon objecten correct zijn
		assertNotNull(persoonLijstFromService);
		
		int i = 0;
		long x = 1L;
		for (Persoon p : persoonLijst) {
			
			if (i == 0) {
				
				assertEquals(x, persoonLijst.get(i).getId());
				assertEquals("Henk", persoonLijst.get(i).getVoornaam());
				assertEquals("Jansen", persoonLijst.get(i).getAchternaam());
				assertEquals("henk.jansen@example.com", persoonLijst.get(i).getEmail());
				assertEquals("Organisator", persoonLijst.get(i).getRol());
				i++;
				x++;
				
			} else if(i == 1) {
				
				assertEquals(x, persoonLijst.get(i).getId());
				assertEquals("Karel", persoonLijst.get(i).getVoornaam());
				assertEquals("de Grote", persoonLijst.get(i).getAchternaam());
				assertEquals("karel.de.grote", persoonLijst.get(i).getEmail());
				assertEquals("Spreker", persoonLijst.get(i).getRol());
				
				
			}
		}
	}
	
	// Deze methode test of een persoon correct wordt opgehaald aan de hand van het gegeven persoonId
	@ParameterizedTest
	@ValueSource(longs = 1L)
	public void testFindById(long persoonId) {
		
		//Given
		// Maak een mock van de PersoonRepository en geef terug dat de mock een Persoon-object teruggeeft, 
		// als findById() wordt aangeroepen met het gegeven persoonId
		Mockito.when(this.persoonRep.findById(persoonId)).thenReturn(this.myPersoon);
		
		//When
		// Roep de findById()-methode aan op de PersoonService met het gegeven persoonId
		Persoon persoonFromService = this.persoonService.findById(persoonId);
		
		//Then
		// Verifieer dat het Persoon-object dat teruggegeven wordt door de PersoonService voldoet aan de verwachte waarden
		assertNotNull(persoonFromService);
		assertEquals(persoonId, persoonFromService.getId());
		assertEquals("Henk", persoonFromService.getVoornaam());
		assertEquals("Jansen", persoonFromService.getAchternaam());
		assertEquals("henk.jansen@example.com", persoonFromService.getEmail());
		assertEquals("Organisator", persoonFromService.getRol());
		
	}
	
	

}
