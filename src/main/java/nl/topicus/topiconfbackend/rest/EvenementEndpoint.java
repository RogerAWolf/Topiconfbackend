package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.domain.Voorstel;
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
	
	@GetMapping("evenement/geefAlleCategorieenPerEvenement/{eventid}")
	public Iterable<Categorie> geefAlleCategorieenPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefCategorieenPerEvenement(event);
	}

	@GetMapping("evenement/geefAlleLocatiesPerEvenement/{eventid}")
	public Iterable<Locatie> geefAlleLocatiesPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefLocatiesPerEvenement(event);
	}
	
	@GetMapping("evenement/geefAlleVoorstellenPerEvenement/{eventid}")
	public Iterable<Voorstel> geefAlleVoorstellenPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefVoorstellenPerEvenement(event);
	}

	@GetMapping("evenement/geefEvenement/{eventid}")
	public Evenement geefEvenement(@PathVariable("eventid") int eventid){
		return es.findById(eventid);
	}

	@GetMapping("evenement/geefEvenement")
	public Iterable<Evenement> geefEvenementMetNaam(@RequestParam String e) {
		return es.haalEvenementOpMetNaam(e);
	}

	@PostMapping("evenement/voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		System.out.println("Evenement opgeslagen");
		es.slaEvenementOp(e1);
	}

	@PostMapping("evenement/voegCategorieAanEvenementToe/{eventid}")
	public void voegCategorieAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Categorie categorie){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnCategorieOp(event, categorie);
	}

	@PostMapping("evenement/voegLocatieAanEvenementToe/{eventid}")
	public void voegLocatieAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Locatie locatie){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnLocatieOp(event, locatie);
	}
	
	@PostMapping("evenement/voegVoorstelAanEvenementToe/{eventid}")
	public void voegVoorstelAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Voorstel voorstel){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnVoorstelOp(event, voorstel);
	}
	
	@DeleteMapping("evenement/verwijderEvent/{eventid}")
	public void verwijderEvent(@PathVariable("eventid") int eventid) {
		System.out.println("Evenement verwijderd");
		es.verwijderEvenement(eventid);
	}
}
