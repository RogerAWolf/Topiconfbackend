package nl.topicus.topiconfbackend.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Spreker;
import nl.topicus.topiconfbackend.persistence.SprekerService;


@RestController
public class SprekerEndpoint {
	
	


	@Autowired
	SprekerService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenSpreker(@RequestBody Spreker spreker) {
		as.toevoegenSpreker(spreker);
	}
	
	@GetMapping("/getBody")
	public Iterable<Spreker> bekijkenSpreker() {
		return as.bekijkSpreker();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Spreker spreker) {
		as.toevoegenSpreker(spreker);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Spreker getById(@PathVariable long id){
		return as.findById(id);
	}

}