package nl.topicus.topiconfbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Organisator;
import nl.topicus.topiconfbackend.persistence.OrganisatorService;


@RestController
public class OrganisatorEndpoint {
	
	


	@Autowired
	OrganisatorService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenOrganisator(@RequestBody Organisator organisator) {
		as.toevoegenOrganisator(organisator);
	}
	
	@GetMapping("/getBody")
	public Iterable<Organisator> bekijkenOrganisator() {
		return as.bekijkOrganisator();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Organisator organisator) {
		as.toevoegenOrganisator(organisator);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Organisator getById(@PathVariable long id){
		return as.findById(id);
	}

}
