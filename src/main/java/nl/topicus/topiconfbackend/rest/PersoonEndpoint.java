package nl.topicus.topiconfbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Persoon;
import nl.topicus.topiconfbackend.persistence.PersoonService;


@RestController
public class PersoonEndpoint {

	@Autowired
	PersoonService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenPersoon(@RequestBody Persoon persoon) {
		as.toevoegenPersoon(persoon);
	}
	
	@GetMapping("/getBody")
	public Iterable<Persoon> bekijkenPersoon() {
		return as.bekijkPersoon();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Persoon persoon) {
		as.toevoegenPersoon(persoon);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Persoon getById(@PathVariable long id){
		return as.findById(id);
	}
	
	
}

