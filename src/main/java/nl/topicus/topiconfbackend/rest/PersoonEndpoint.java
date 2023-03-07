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

<<<<<<<< HEAD:src/main/java/nl/topicus/topiconfbackend/rest/PersoonEndpoint.java
import nl.topicus.topiconfbackend.domain.Persoon;
import nl.topicus.topiconfbackend.persistence.PersoonService;


@RestController
public class PersoonEndpoint {
	
	


	@Autowired
	PersoonService as;
========
import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.persistence.VoorstelService;

@RestController
public class VoorstelEndPoint {

	@Autowired
	VoorstelService as;
>>>>>>>> main:src/main/java/nl/topicus/topiconfbackend/rest/VoorstelEndPoint.java
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("/postBody")
<<<<<<<< HEAD:src/main/java/nl/topicus/topiconfbackend/rest/PersoonEndpoint.java
	public void toevoegenPersoon(@RequestBody Persoon persoon) {
		as.toevoegenPersoon(persoon);
	}
	
	@GetMapping("/getBody")
	public Iterable<Persoon> bekijkenPersoon() {
		return as.bekijkPersoon();
========
	public void toevoegenVoorstel(@RequestBody Voorstel voorstel) {
		as.toevoegenVoorstel(voorstel);
	}
	
	@GetMapping("/getBody")
	public Iterable<Voorstel> bekijkenVoorstel() {
		return as.bekijkVoorstel();
>>>>>>>> main:src/main/java/nl/topicus/topiconfbackend/rest/VoorstelEndPoint.java
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("/updateElementStatus/{id}")
<<<<<<<< HEAD:src/main/java/nl/topicus/topiconfbackend/rest/PersoonEndpoint.java
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Persoon persoon) {
		as.toevoegenPersoon(persoon);
========
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Voorstel voorstel) {
		as.toevoegenVoorstel(voorstel);
>>>>>>>> main:src/main/java/nl/topicus/topiconfbackend/rest/VoorstelEndPoint.java
	}
	
	
	@CrossOrigin
	@GetMapping("/getElement/{id}")
<<<<<<<< HEAD:src/main/java/nl/topicus/topiconfbackend/rest/PersoonEndpoint.java
	public Persoon getById(@PathVariable long id){
		return as.findById(id);
	}

========
	public Voorstel getById(@PathVariable long id){
		return as.findById(id);
	}
	
	
>>>>>>>> main:src/main/java/nl/topicus/topiconfbackend/rest/VoorstelEndPoint.java
}
