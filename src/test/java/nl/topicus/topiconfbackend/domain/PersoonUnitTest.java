package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersoonUnitTest {

	@Test
	public void testPersoonVoornaam() {
		Persoon p = new Persoon();
		assertEquals("Voornaam", p.getVoornaam());
	}
	
	@Test
	public void testPersoonAchternaam() {
		Persoon p = new Persoon();
		assertEquals("Achternaam", p.getAchternaam());
	}
	
	@Test
	public void testPersoonEmail() {
		Persoon p = new Persoon();
		assertEquals("voornaam.achternaam@example.nl", p.getEmail());
	}
}
