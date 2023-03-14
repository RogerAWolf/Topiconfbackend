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

import nl.topicus.topiconfbackend.domain.Presentatie;

public class PresentatieServiceIT {
	
	@Mock
	private PresentatieRepository presentatieRepository;
	private static final Presentatie mockedPresentatie1;
	private static final Presentatie mockedPresentatie2;
	private static final Optional<Presentatie> myPresentatie;
	private static final ArrayList<Presentatie> presentatieLijst;
	
	@InjectMocks
	private PresentatieService presentatieService;
	
	public PresentatieServiceIT() {
		
		MockitoAnnotations.openMocks(this);
	}
	
	static {
		mockedPresentatie1 = new Presentatie();
		mockedPresentatie1.setId(1L);
		mockedPresentatie1.setOnderwerp("Containers");
		mockedPresentatie1.setSamenvatting("Wat doen containers en hoe gebruik je ze");
		mockedPresentatie1.setTijdsduur(60);
		mockedPresentatie1.setFaciliteiten("Beamer, Whiteboard, Stiften");
		
		myPresentatie = Optional.of(mockedPresentatie1);
		
		mockedPresentatie2 = new Presentatie();
		mockedPresentatie2.setId(2L);
		mockedPresentatie2.setOnderwerp("Testen");
		mockedPresentatie2.setSamenvatting("De verschillende testen die gebruikt kunnen worden");
		mockedPresentatie2.setTijdsduur(45);
		mockedPresentatie2.setFaciliteiten("Beamer");
		
		presentatieLijst = new ArrayList<Presentatie>();
		presentatieLijst.add(mockedPresentatie1);
		presentatieLijst.add(mockedPresentatie2);
	}
	
	@ParameterizedTest
	@MethodSource
	public void testToevoegenPresentatie(Presentatie presentatie) {
		
		assertNotNull(presentatie);
		assertEquals(true, presentatieService.toevoegenPresentatie(presentatie));
		assertEquals(false, presentatieService.toevoegenPresentatie(presentatie));
	}
	
	@Test
	public void testBekijkPresentatie() {
		
		//Given
		Mockito.when(this.presentatieRepository.findAll()).thenReturn(this.presentatieLijst);
		
		//When
		Iterable<Presentatie> presentatieLijstFromService = ((PresentatieService) this.presentatieRepository).bekijkPresentatie();
		
		//Then
		assertNotNull(presentatieLijstFromService);
		
		int i = 0;
		long x = 1L;
		for (Presentatie p : presentatieLijst) {
			
			if (i == 0) {
				
				assertEquals(x, presentatieLijst.get(i).getId());
				assertEquals("Containers", presentatieLijst.get(i).getOnderwerp());
				assertEquals("Wat doen containers en hoe gebruik je ze", presentatieLijst.get(i).getSamenvatting());
				assertEquals(60, presentatieLijst.get(i).getTijdsduur());
				assertEquals("Beamer, Whiteboard, Stiften", presentatieLijst.get(i).getFaciliteiten());
				i++;
				x++; 
			
			} else if(i == 1) {
				
				assertEquals(x, presentatieLijst.get(i).getId());
				assertEquals("Testen", presentatieLijst.get(i).getOnderwerp());
				assertEquals("De verschillende testen die gebruikt kunnen worden", presentatieLijst.get(i).getSamenvatting());
				assertEquals(45, presentatieLijst.get(i).getTijdsduur());
				assertEquals("Beamer", presentatieLijst.get(i).getFaciliteiten());
			}
		}
	}
	
	@ParameterizedTest
	@ValueSource(longs = 1L)
	public void testFindById(long presentatieId) {
		
		//Given
		Mockito.when(this.presentatieRepository.findById(presentatieId)).thenReturn(this.myPresentatie);
		
		//When
		Presentatie presentatieFromService = this.presentatieService.findById(presentatieId);
		
		//Then
		assertNotNull(presentatieFromService);
		assertEquals(presentatieId, presentatieFromService.getId());
		assertEquals("Containers", presentatieFromService.getOnderwerp());
		assertEquals("Wat doen containers en hoe gebruik je ze", presentatieFromService.getSamenvatting());
		assertEquals(60, presentatieFromService.getTijdsduur());
		assertEquals("Beamer, Whiteboard, Stiften", presentatieFromService.getFaciliteiten());
	}

}
