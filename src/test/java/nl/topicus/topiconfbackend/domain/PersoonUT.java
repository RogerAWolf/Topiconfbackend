package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersoonUT {
	private Persoon persoon;
	
	public PersoonUT() {
		this.persoon = new Persoon();
	}
	
	@Test
	@DisplayName("Should be able to set id")
	public void testGetAndSetId() {
		persoon.setId(10L);
		assertEquals(10L, persoon.getId(), "Should be able to set id correcly");
	}
	
	@Test
	@DisplayName("Should be able to set voornaam")
	public void testGetAndSetVoornaam() {
		persoon.setVoornaam("Willem");
		assertEquals("Willem", persoon.getVoornaam(), "Should be able to set voornaam correcly");
	}
	
	@Test
	@DisplayName("Should be able to set achternaam")
	public void testGetAndSetAchternaam() {
		persoon.setAchternaam("Wever");
		assertEquals("Wever", persoon.getAchternaam(), "Should be able to set achternaam correcly");
	}
	
//	@Test
//	@DisplayName("Should throw exception when null value parameter is given")
//	public void exceptionTestSetAchternaam() {
//		Throwable exception = assertThrows(IllegalArgumentException.class, () -> persoon.setAchternaam(null));
//	    assertNotNull("Achternaam must not be null.", exception.getMessage());
//	}
	
	@Test
	@DisplayName("Should be able to set email")
	public void testGetAndSetEmail() {
		persoon.setEmail("Willem_Wever@gmail.com");
		assertEquals("Willem_Wever@gmail.com", persoon.getEmail(), "Should be able to set email correcly");
	}
}
