package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.persistence.EvenementService;

@RestController
public class EvenementEndpoint {

	@Autowired
	EvenementService es;
	
	@GetMapping("evenement/alleEvenementen")
	public Iterable<Evenement> alleEvenementen() {
		return es.geefAlleEvenementen();
	}

	@GetMapping("evenement/geefAlleTracksPerEvenement/{eventid}")
	public Iterable<Track> geefAlleTracksPerEvenement(@PathVariable("eventid") int eventid){
		Evenement event = es.findById(eventid);
		return es.geefTracksPerEvenement(event);
	}
	
	@PostMapping("evenement/voegEvenementToe")
	public void voegEvenementToe(@RequestBody Evenement e1) {
		es.slaEvenementOp(e1);
	}

	@PostMapping("evenement/voegTrackAanEvenementToe/{eventid}")
	public void voegTrackAanEvenementToe(@PathVariable("eventid") int eventid, @RequestBody Track track){
		Evenement event = es.findById(eventid);
		es.slaEvenementEnTrackOp(event, track);
	}


}
