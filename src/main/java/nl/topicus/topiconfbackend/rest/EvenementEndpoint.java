package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.*;
import nl.topicus.topiconfbackend.persistence.VoorstelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.persistence.EvenementService;

@RestController
public class EvenementEndpoint {

	@Autowired
	EvenementService evenementService;

	@Autowired
	VoorstelService voorstelService;

	@GetMapping("evenement/geefAlleEvenementen")
	public Iterable<Evenement> geefAlleEvenementen() {
		return evenementService.geefAlleEvenementen();
	}
	
	@GetMapping("evenement/geefAlleCategorieenPerEvenement/{evenementid}")
	public Iterable<Categorie> geefAlleCategorieenPerEvenement(@PathVariable("evenementid") int evenementid){
		Evenement evenement = evenementService.findById(evenementid);
		return evenementService.geefAlleCategorieenPerEvenement(evenement);
	}

	@GetMapping("evenement/geefAlleLocatiesPerEvenement/{evenementid}")
	public Iterable<Locatie> geefAlleLocatiesPerEvenement(@PathVariable("evenementid") int evenementid){
		Evenement evenement = evenementService.findById(evenementid);
		return evenementService.geefAlleLocatiesPerEvenement(evenement);
	}
	
	@GetMapping("evenement/geefAlleVoorstellenPerEvenement/{evenementid}")
	public Iterable<Voorstel> geefAlleVoorstellenPerEvenement(@PathVariable("evenementid") int evenementid){
		Evenement evenement = evenementService.findById(evenementid);
		return evenementService.geefAlleVoorstellenPerEvenement(evenement);
	}

	@GetMapping("evenement/geefEvenementPerId/{evenementid}")
	public Evenement geefEvenementPerId(@PathVariable("evenementid") int evenementid){
		return evenementService.findById(evenementid);
	}

	@GetMapping("evenement/geefEvenementPerNaam")
	public Iterable<Evenement> geefEvenementPerNaam(@RequestParam String e) {
		return evenementService.geefEvenementPerNaam(e);
	}

	@PostMapping("evenement/slaEvenementOp")
	public void slaEvenementOp(@RequestBody Evenement evenement) {
		evenementService.slaEvenementOp(evenement);
	}

	@PostMapping("evenement/voegCategorieAanEvenementToe/{evenementid}")
	public void voegCategorieAanEvenementToe(@PathVariable("evenementid") int evenementid, @RequestBody Categorie categorie){
		Evenement evenement = evenementService.findById(evenementid);
		evenementService.slaEvenementEnCategorieOp(evenement, categorie);
	}

	@PostMapping("evenement/voegLocatieAanEvenementToe/{evenementid}")
	public void voegLocatieAanEvenementToe(@PathVariable("evenementid") int evenementid, @RequestBody Locatie locatie){
		Evenement evenement = evenementService.findById(evenementid);
		evenementService.slaEvenementEnLocatieOp(evenement, locatie);
	}
	
	@PostMapping("evenement/voegVoorstelAanEvenementToe/{evenementid}")
	public void voegVoorstelAanEvenementToe(@PathVariable("evenementid") int evenementid, @RequestBody Voorstel voorstel){
		Evenement evenement = evenementService.findById(evenementid);
		evenementService.slaEvenementEnVoorstelOp(evenement, voorstel);
		Spreker spreker1 = new Spreker();
		spreker1.setVoornaam(voorstel.getVoornaam());
		spreker1.setAchternaam(voorstel.getAchternaam());
		spreker1.setEmail(voorstel.geteMail());
		spreker1.setRol("s");
		voorstelService.slaVoorstelEnSprekerOp(voorstel, spreker1);
	}
	
	@DeleteMapping("evenement/verwijderEvenement/{evenementid}")
	public void verwijderEvenement(@PathVariable("evenementid") int evenementid) {
		evenementService.verwijderEvenement(evenementid);
	}
}
