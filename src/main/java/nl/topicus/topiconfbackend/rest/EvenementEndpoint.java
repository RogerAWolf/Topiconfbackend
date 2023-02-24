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
	
	@GetMapping("event/alleEvenementen")
	public Iterable<Evenement> alleEvenementen() {
		System.out.println("Alle evenementen opgehaald");
		return es.geefAlleEvenementen();
	}
	
	@PostMapping("event/voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		System.out.println("Evenement opgeslagen");
		es.slaEvenementOp(e1);
	}
	
	@DeleteMapping("event/verwijderEvent/{eventid}")
	public void verwijderEvent(@PathVariable("eventid") int eventid) {
		System.out.println("Evenement verwijderd");
		es.verwijderEvenement(eventid);
	}
}
