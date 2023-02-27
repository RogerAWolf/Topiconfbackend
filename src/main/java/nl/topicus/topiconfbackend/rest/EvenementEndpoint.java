package nl.topicus.topiconfbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.persistence.EvenementService;

@RestController
public class EvenementEndpoint {

	@Autowired
	EvenementService es;
	
	@GetMapping("evenement/alleEvenementen")
	public Iterable<Evenement> alleEvenementen() {
		System.out.println("Alle evenementen opgehaald");
		return es.geefAlleEvenementen();
	}
	
	@GetMapping("evenement/alleEvenementen/{eventid}")
	public void aanvraagBekijken(@PathVariable("eventid") int eventid)
	{
		System.out.println("Redirect to event ID: " + eventid);
		
	}
	
	
	@PostMapping("evenement/voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		System.out.println("Evenement opgeslagen");
		es.slaEvenementOp(e1);
	}
	
	@DeleteMapping("evenement/verwijderEvent/{eventid}")
	public void verwijderEvent(@PathVariable("eventid") int eventid) {
		System.out.println("Evenement verwijderd");
		es.verwijderEvenement(eventid);
	}
}
