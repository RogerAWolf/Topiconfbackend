package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VoorstelUnitTest {
	
	@Test
    public void testVoorstelStatus() {
        Voorstel voorstel = new Voorstel();
        assertEquals("ongemarkeerd", voorstel.getStatus());
        
        voorstel.setStatus("gemarkeerd");
        assertEquals("gemarkeerd", voorstel.getStatus());
    }
	
	@Test
    public void testVoorstelNaam() {
        Voorstel voorstel = new Voorstel();
        voorstel.setNaam("John");
        voorstel.setVoornaam("Doe");
        assertEquals("John", voorstel.getNaam());
        assertEquals("Doe", voorstel.getVoornaam());
    }
    
    @Test
    public void testVoorstelOnderwerp() {
    	Voorstel voorstel = new Voorstel();
    	voorstel.setOnderwerp("Testen");
    	assertEquals("Testen", voorstel.getOnderwerp());
    }
    
    @Test
    public void testAanvraagEmail() {
    	Voorstel voorstel = new Voorstel();
    	voorstel.seteMail("john.joe@example.com");
    	assertEquals("john.joe@example.com", voorstel.geteMail());
    }
    
    
    

}
