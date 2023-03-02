package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AanvraagTest {
	
	@Test
	public void getAndsetNaamTest() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.setNaam("Popov");
		assertEquals("Popov", aanvraag.getNaam());
	}
	
	@Test
	public void getAndsetVoorNaamTest() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.setVoornaam("Alex");
		assertEquals("Alex", aanvraag.getVoornaam());
	}
	
	@Test
	public void getAndsetOnderwerpTest() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.setOnderwerp("UnitTest");
		assertEquals("UnitTest", aanvraag.getOnderwerp());
	}
	
	@Test
	public void getAndsetEmailTest() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.seteMail("Alex.hotmail.com");
		assertEquals("Alex.hotmail.com", aanvraag.geteMail());
	}
	
	@Test
	public void getAndsetStatusTest() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.setStatus("ongemarkeerd");
		assertEquals("ongemarkeerd", aanvraag.getStatus());
		//assertEquals("gemarkeerd", aanvraag.getStatus());
		
	}

}
