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
	PresentatieService presentatieService;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("presentatie/slaPresentatieOp")
	public void slaPresentatieOp(@RequestBody Presentatie presentatie) {
		presentatieService.slaPresentatieOp(presentatie);
	}
	
	@GetMapping("presentatie/geefAllePresentaties")
	public Iterable<Presentatie> geefAllePresentaties() {
		return presentatieService.geefAllePresentaties();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("presentatie/updatePresentatie/{id}")
	public void updatePresentatie(@PathVariable long id, @RequestBody Presentatie presentatie) {
		presentatieService.slaPresentatieOp(presentatie);
	}
	
	
	@CrossOrigin
	@GetMapping("presentatie/geefPresentatiePerId/{id}")
	public Presentatie getById(@PathVariable long id){
		return presentatieService.findById(id);
	}

}