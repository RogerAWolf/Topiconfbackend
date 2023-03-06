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

import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.persistence.VoorstelService;

@RestController
public class VoorstelEndPoint {

	@Autowired
	VoorstelService vs;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
	public void toevoegenVoorstel(@RequestBody Voorstel voorstel) {
		vs.toevoegenVoorstel(voorstel);
	}
	
	@GetMapping("/getBody")
	public Iterable<Voorstel> bekijkenVoorstel() {
		return vs.bekijkVoorstel();
	}

	@GetMapping("/voorstel/getVoorstelById/{id}")
	public Voorstel getVoorstelByID(@PathVariable long id){
		return vs.findById(id);
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Voorstel voorstel) {
		vs.toevoegenVoorstel(voorstel);
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
	public Voorstel getById(@PathVariable long id){
		return vs.findById(id);
	}
	
	
}
