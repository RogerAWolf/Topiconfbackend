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

import nl.topicus.topiconfbackend.domain.Presentatie;
import nl.topicus.topiconfbackend.persistence.PresentatieService;


@RestController
public class PresentatieEndpoint {
	
	


	@Autowired
	PresentatieService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenPresentatie(@RequestBody Presentatie presentatie) {
		as.toevoegenPresentatie(presentatie);
	}
	
	@GetMapping("/getBody")
	public Iterable<Presentatie> bekijkenPresentatie() {
		return as.bekijkPresentatie();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Presentatie presentatie) {
		as.toevoegenPresentatie(presentatie);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Presentatie getById(@PathVariable long id){
		return as.findById(id);
	}

}