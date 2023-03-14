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

import nl.topicus.topiconfbackend.domain.Persoon;
import nl.topicus.topiconfbackend.persistence.PersoonService;


@RestController
public class PersoonEndpoint {

	@Autowired
	PersoonService persoonService;
	
	//add request to database
	//fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("persoon/slaPersoonOp")
	public void slaPersoonOp(@RequestBody Persoon persoon) {
		persoonService.slaPersoonOp(persoon);
	}
	
	@GetMapping("persoon/geefAllePersonen")
	public Iterable<Persoon> geefAllePersonen() {
		return persoonService.geefAllePersonen();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("persoon/updatePersoon/{id}")
	public void updatePersoon(@PathVariable long id, @RequestBody Persoon persoon) {
		persoonService.slaPersoonOp(persoon);
	}

	@CrossOrigin
	@GetMapping("persoon/geefPersoonPerId/{id}")
	public Persoon geefPersoonPerId(@PathVariable long id){
		return persoonService.findById(id);
	}

}