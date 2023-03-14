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
	AdministratorService administratorService;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("administrator/slaAdministratorOp")
	public void slaAdministratorOp(@RequestBody Administrator administrator) {
		administratorService.slaAdministratorOp(administrator);
	}
	
	@GetMapping("administrator/geefAlleAdministrators")
	public Iterable<Administrator> geefAlleAdministators() {
		return administratorService.geefAlleAdministrators();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("administrator/updateAdministrator/{id}")
	public void updateAdministator(@PathVariable long id, @RequestBody Administrator administrator) {
		administratorService.slaAdministratorOp(administrator);
	}

	@CrossOrigin
	@GetMapping("administrator/geefAdministratorPerId/{id}")
	public Administrator geefAdministratorPerId(@PathVariable long id){
		return administratorService.geefAdministratorPerId(id);
	}

}