package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import nl.topicus.topiconfbackend.domain.Spreker;
import nl.topicus.topiconfbackend.persistence.BenodigdheidService;
import nl.topicus.topiconfbackend.persistence.CategorieService;
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
	VoorstelService voorstelService;

	@Autowired
    CategorieService categorieService;

	@Autowired
	BenodigdheidService benodigheidService;
	
	// add request to database
	// frontend will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("voorstel/voorstelOpslaan")
	public void toevoegenVoorstel(@RequestBody Voorstel voorstel, @RequestParam("categorieid") int categorieid) {
		voorstel.setCategorie(this.categorieService.findById(categorieid));
		this.voorstelService.toevoegenVoorstel(voorstel);
	}

	@GetMapping("voorstel/geefAlleVoorstellen")
	public Iterable<Voorstel> geefAlleVoorstellen(){
		return this.voorstelService.bekijkAlleVoorstellen();
	}

	@GetMapping("voorstel/getVoorstelById/{id}")
	public Voorstel getVoorstelByID(@PathVariable long id){
		return this.voorstelService.findById(id);
	}
	
	// not able to use yet
	@CrossOrigin
	@PutMapping("voorstel/updateElementStatus/{id}")
	public void selecterenEnUpdate(@PathVariable long id, @RequestBody Voorstel voorstel) {
		this.voorstelService.toevoegenVoorstel(voorstel);
	}

	@PostMapping("voorstelEnSpreker/postBody")
	public void toevoegenSprekerBijVoorstel(@RequestBody Voorstel voorstel){
		Voorstel voorstel1 = new Voorstel();
		voorstel1.setOnderwerp(voorstel.getOnderwerp());
		voorstel1.seteMail(voorstel.geteMail());
		voorstel1.setSamenvatting(voorstel.getSamenvatting());
		Spreker spreker1 = new Spreker();
		spreker1.setEmail(voorstel.geteMail());
		voorstelService.slaDezeVoorstelEnSprekerOp(voorstel1, spreker1);
	}

	@PostMapping("voorstel/voegBenodigdheidAanVoorstelToe/{benodigdheidid}")
	public void voegBenodigdheidAanVoorstelToe(@PathVariable("voorstelid") int voorstelid, @RequestBody Benodigdheid benodigdheid){

	}

}
