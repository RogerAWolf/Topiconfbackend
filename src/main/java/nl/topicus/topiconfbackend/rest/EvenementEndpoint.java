package nl.topicus.topiconfbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.persistence.EvenementService;

@RestController
public class EvenementEndpoint {

	@Autowired
	EvenementService es;
	
	@GetMapping("alleEvenementen")
	public Iterable<Evenement> alleEvenementen() {
		return es.geefAlleEvenementen();
	}
	
	@PostMapping("voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		es.slaEvenementOp(e1);
	}
}
