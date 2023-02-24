package nl.topicus.topiconfbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Aanvraag;
import nl.topicus.topiconfbackend.persistence.AanvraagService;

@RestController
public class RequestEndPoint {

	@Autowired
	AanvraagService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public Aanvraag toevoegenAanvraag(@RequestBody Aanvraag aanvraag) {
		return as.toevoegenAanvraag(aanvraag);
	}
	
	@GetMapping("/getBody")
	public Iterable<Aanvraag> bekijkenAanvraag() {
		return as.bekijkAanvraag();
	}
	
}
