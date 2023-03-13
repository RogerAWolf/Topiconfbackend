package nl.topicus.topiconfbackend.persistence;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	
	@Mock
	private PersoonRepository persoonRep;
	private static final Persoon mockedPersoon1;
	private static final Persoon mockedPersoon2;
	private static final Optional<Persoon> myPersoon;
	private static final ArrayList<Persoon> persoonLijst;
	
	@InjectMocks
	private PersoonService persoonService;
	
	public PersoonServiceIT() {
		
		MockitoAnnotations.openMocks(this);
	}
	
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
	
	@ParameterizedTest
	@MethodSource
	public void testToevoegenPersoon(Persoon persoon) {
		
		assertNotNull(persoon);
		assertEquals(true, persoonService.toevoegenPersoon(persoon));
		assertEquals(false, persoonService.toevoegenPersoon(null));
	}
	
	@Test
	public void testBekijkPersoon() {
		
		//Given
		Mockito.when(this.persoonRep.findAll()).thenReturn(this.persoonLijst);
		
		//When
		Iterable<Persoon> persoonLijstFromService = ((PersoonService) this.persoonRep).bekijkPersoon();
		
		//Then
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
	
	@ParameterizedTest
	@ValueSource(longs = 1L)
	public void testFindById(long persoonId) {
		
		//Given
		Mockito.when(this.persoonRep.findById(persoonId)).thenReturn(this.myPersoon);
		
		//When
		Persoon persoonFromService = this.persoonService.findById(persoonId);
		
		//Then
		assertNotNull(persoonFromService);
		assertEquals(persoonId, persoonFromService.getId());
		assertEquals("Henk", persoonFromService.getVoornaam());
		assertEquals("Jansen", persoonFromService.getAchternaam());
		assertEquals("henk.jansen@example.com", persoonFromService.getEmail());
		assertEquals("Organisator", persoonFromService.getRol());
		
	}
	
	

}
