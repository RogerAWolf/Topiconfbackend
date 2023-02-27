package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.domain.Aanvraag;
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
	public Iterable<Aanvraag> aanvraagBekijken(@PathVariable("eventid") int eventid)
	{
		System.out.println("Redirect to event ID: " + eventid);
		Evenement event = es.findById(eventid);
		return es.geefAlleAanvragen(event);
	}
	
	
	@GetMapping("evenement/geefAlleTracksPerEvenement/{eventid}")
	public Iterable<Track> geefAlleTracksPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefTracksPerEvenement(event);
	}

	@GetMapping("evenement/geefAlleLocatiesPerEvenement/{eventid}")
	public Iterable<Locatie> geefAlleLocatiesPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefLocatiesPerEvenement(event);
	}

	@GetMapping("evenement/geefEvenement/{eventid}")
	public Evenement geefEvenement(@PathVariable("eventid") int eventid){
		return es.findById(eventid);
	}


	@PostMapping("evenement/voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		System.out.println("Evenement opgeslagen");
		es.slaEvenementOp(e1);
	}

	@PostMapping("evenement/voegTrackAanEvenementToe/{eventid}")
	public void voegTrackAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Track track){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnTrackOp(event, track);
	}

	@PostMapping("evenement/voegLocatieAanEvenementToe/{eventid}")
	public void voegLocatieAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Locatie locatie){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnLocatieOp(event, locatie);
	}

	
	@DeleteMapping("evenement/verwijderEvent/{eventid}")
	public void verwijderEvent(@PathVariable("eventid") int eventid) {
		System.out.println("Evenement verwijderd");
		es.verwijderEvenement(eventid);
	}
}
