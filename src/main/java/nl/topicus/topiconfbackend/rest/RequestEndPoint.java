package nl.topicus.topiconfbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void toevoegenAanvraag(@RequestBody Aanvraag aanvraag) {
		as.toevoegenAanvraag(aanvraag);
	}
	
	@GetMapping("/getBody")
	public Iterable<Aanvraag> bekijkenAanvraag() {
		return as.bekijkAanvraag();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Aanvraag aanvraag) {
		as.toevoegenAanvraag(aanvraag);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Aanvraag getById(@PathVariable long id){
		return as.findById(id);
	}
	
	
}
