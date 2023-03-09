package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PresentatieUnitTest {
	
	private Presentatie presentatie;
	
	@Test
	public void testPresentatieOnderwerp() {
		Presentatie p = new Presentatie();
		assertEquals("Mijn eerste presentatie", p.getOnderwerp());
	}
	
	@Test
	public void testPresentatieSamenvatting() {
		Presentatie p = new Presentatie();
		assertEquals("Dit is mijn samenvatting van mijn eerste presentatie", p.getSamenvatting());
	}
	
	@Test
	public void testPresentatieTijdsduur() {
		Presentatie p = new Presentatie();
		//tijdsduur in minuten
		assertEquals(30, p.getTijdsduur());
	}
	
	@Test
	public void testPresentatieFaciliteiten() {
		Presentatie p = new Presentatie();
		assertEquals("Microfoon, Whiteboard, Whiteboard stiften", p.getFaciliteiten());
	}
	
	@Test
	public void testPresentatieSprekerList() {
		List<Spreker> testSprekerList = new ArrayList<>();
		Spreker testSpreker = new Spreker();
		testSprekerList.add(testSpreker);
		
		presentatie.setSprekerList(testSprekerList);
		assertEquals(testSprekerList, presentatie.getSprekerList());
	}
	
	@Test
	public void testPresentatieCatergorie() {
		Presentatie p = new Presentatie();
		Categorie c = new Categorie();
		assertEquals(c, p.getCategorie());
	}

}
