package nl.topicus.topiconfbackend.rest;

import java.util.List;
import java.util.Optional;

import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.Persoon;
import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.persistence.PersoonService;
import nl.topicus.topiconfbackend.persistence.VoorstelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Spreker;
import nl.topicus.topiconfbackend.persistence.SprekerService;


@RestController
public class SprekerEndpoint {

	@Autowired
	SprekerService sprekerService;

	@Autowired
	VoorstelService voorstelService;
	
	//add request to database
	//fronted will make sure that all fields are filled

	@CrossOrigin
	@PostMapping("spreker/slaSprekerOp")
	public void slaSprekerOp(@RequestBody Spreker spreker) {
		sprekerService.slaSprekerOp(spreker);
	}

	@GetMapping("spreker/geefAlleSprekers")
	public Iterable<Spreker> geefAlleSprekers() {
		return sprekerService.geefAlleSprekers();
	}

	//not able to use yet
	@CrossOrigin
	@PutMapping("spreker/updateSpreker/{id}")
	public void updateSpreker(@PathVariable long id, @RequestBody Spreker spreker) {
		sprekerService.slaSprekerOp(spreker);
	}

	@CrossOrigin
	@GetMapping("spreker/geefSprekerPerId/{id}")
	public Spreker geefSprekerPerId(@PathVariable long id){
		return sprekerService.findById(id);
	}

	@PutMapping("spreker/voegVoorstelAanSprekerToe/{sprekerid}")
	public void updateSpreker(@PathVariable("sprekerid") int sprekerid, @RequestBody Voorstel voorstel){
		Spreker spreker = sprekerService.findById(sprekerid);
		voorstel.setSpreker(spreker);
		voorstelService.slaVoorstelOp(voorstel);
		spreker.getVoorstelLijst().add(voorstel);
		sprekerService.slaSprekerOp(spreker);
	}

	@GetMapping("spreker/geefVoorstellenPerSpreker/{sprekerid}")
	public List<Voorstel> geefVoorstellenPerSpreker(@PathVariable("sprekerid") int sprekerid){
		Spreker huidigeSpreker = sprekerService.findById(sprekerid);
		System.out.println("Voorstellen van: " + huidigeSpreker.getVoornaam());
		return huidigeSpreker.getVoorstelLijst();
	}
}