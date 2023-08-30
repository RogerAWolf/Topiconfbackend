package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.*;
import nl.topicus.topiconfbackend.persistence.PersoonService;
import nl.topicus.topiconfbackend.persistence.VoorstelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.topicus.topiconfbackend.persistence.EvenementService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EvenementEndpoint {

	@Autowired
	EvenementService evenementService;

	@Autowired
	VoorstelService voorstelService;

	@Autowired
	PersoonService persoonService;

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

	@CrossOrigin
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
		Categorie geenCategorie = new Categorie();
		geenCategorie.setName("geenCategorie");
		geenCategorie.setDescription("Standaard categorie");
		evenementService.slaEvenementEnCategorieOp(evenement, geenCategorie);
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
		voorstel.setCategorie(evenement.getCategorieLijst().get(0));
		evenementService.slaEvenementEnVoorstelOp(evenement, voorstel);
		Spreker spreker1 = new Spreker();
		spreker1.setVoornaam(voorstel.getVoornaam());
		spreker1.setAchternaam(voorstel.getAchternaam());
		spreker1.setEmail(voorstel.geteMail());
		spreker1.setRol("s");
		List <Voorstel> voorstelLijst = new ArrayList<>();
		voorstelLijst.add(voorstel);
		spreker1.setVoorstelLijst(voorstelLijst); //NIEUW
		voorstelService.slaVoorstelEnSprekerOp(voorstel, spreker1);
	}
	
	@DeleteMapping("evenement/verwijderEvenement/{evenementid}")
	public void verwijderEvenement(@PathVariable("evenementid") int evenementid) {
		evenementService.verwijderEvenement(evenementid);
	}

	@PutMapping("evenement/updateEvenement/{evenementid}")
	public void updateEvenement(@PathVariable("evenementid") int evenementid, @RequestBody Evenement evenement)
	{
		Evenement teUpdatenEvenement = evenementService.findById(evenementid);
		teUpdatenEvenement.setNaam(evenement.getNaam());
		teUpdatenEvenement.setOmschrijving(evenement.getOmschrijving());
		teUpdatenEvenement.setBeginDatumTijd(evenement.getBeginDatumTijd());
		teUpdatenEvenement.setEindDatumTijd(evenement.getEindDatumTijd());
		evenementService.slaEvenementOp(teUpdatenEvenement);
	}

	@PutMapping("/evenement/verwijderOrganisatorVanEvenement/{evenementid}")
	public void updateOrganisatorVoorEvenement(@PathVariable("evenementid") int evenementid, @RequestParam("organisatorid") int organisatorid)
	{
		Evenement evenement = evenementService.findById(evenementid);
		Persoon teVerwijderenPersoon = persoonService.findById(organisatorid);
		evenement.getPersoonLijst().remove(teVerwijderenPersoon);
		evenementService.slaEvenementOp(evenement);
	}

	@PostMapping("/evenement/voegOrganisatorToeAanEvenement/{evenementid}")
	public void voegOrganisatorToeAanEvenement(@PathVariable("evenementid") int evenementid, @RequestBody Organisator organisator){
		Persoon nieuweOrganisator = organisator;
		nieuweOrganisator.setRol("o");
		persoonService.slaPersoonOp(nieuweOrganisator);
		Evenement huidigEvenement = evenementService.findById(evenementid);
		huidigEvenement.getPersoonLijst().add(nieuweOrganisator);
		evenementService.slaEvenementOp(huidigEvenement);
	}
}
