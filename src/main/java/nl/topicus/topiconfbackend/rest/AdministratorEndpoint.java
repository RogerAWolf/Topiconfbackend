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

import nl.topicus.topiconfbackend.domain.Administrator;
import nl.topicus.topiconfbackend.persistence.AdministratorService;


@RestController
public class AdministratorEndpoint {
	
	


	@Autowired
	AdministratorService as;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenAdministrator(@RequestBody Administrator administrator) {
		as.toevoegenAdministrator(administrator);
	}
	
	@GetMapping("/getBody")
	public Iterable<Administrator> bekijkenAdministrator() {
		return as.bekijkAdministrator();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Administrator administrator) {
		as.toevoegenAdministrator(administrator);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Administrator getById(@PathVariable long id){
		return as.findById(id);
	}

}