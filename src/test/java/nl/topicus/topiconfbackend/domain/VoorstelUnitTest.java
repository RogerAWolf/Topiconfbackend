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
//        voorstel.setVoornaam("Naam");
//        voorstel.setAchternaam("Achternaam");
//        assertEquals("Naam", voorstel.getVoornaam());
//        assertEquals("Achternaam", voorstel.getAchternaam());
    }
    
    @Test
    public void testVoorstelOnderwerp() {
    	Voorstel voorstel = new Voorstel();
    	voorstel.setOnderwerp("Testen");
    	assertEquals("Testen", voorstel.getOnderwerp());
    }
    
    @Test
    public void testVoorstelEmail() {
    	Voorstel voorstel = new Voorstel();
//    	voorstel.seteMail("naam.achternaam@example.com");
//    	assertEquals("naam.achternaam@example.com", voorstel.geteMail());
    }
    
    
    

}
