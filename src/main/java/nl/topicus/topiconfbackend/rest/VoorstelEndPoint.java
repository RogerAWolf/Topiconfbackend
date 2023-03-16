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

import java.util.ArrayList;
import java.util.List;

@RestController
public class VoorstelEndPoint {

	@Autowired
	VoorstelService voorstelService;

	@Autowired
    CategorieService categorieService;

	@Autowired
	BenodigdheidService benodigdheidService;
	
	// add request to database
	// frontend will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("voorstel/slaVoorstelOp")
	public void slaVoorstelOp(@RequestBody Voorstel voorstel) {
		this.voorstelService.slaVoorstelOp(voorstel);
	}

	@GetMapping("voorstel/geefAlleVoorstellen")
	public Iterable<Voorstel> geefAlleVoorstellen(){
		return this.voorstelService.geefAlleVoorstellen();
	}

	@GetMapping("voorstel/geefVoorstelPerId/{id}")
	public Voorstel geefVoorstelPerId(@PathVariable("id") long id){
		return this.voorstelService.findById(id);
	}
	
	// not able to use yet
	@CrossOrigin
	@PutMapping("voorstel/updateVoorstel")
	public void updateVoorstel(@RequestBody Voorstel voorstel) {
		voorstel.setVeranderd(true);

		List<Benodigdheid> nieuweBenodigdheden = new ArrayList<>();
		for(Benodigdheid benodigdheid: voorstel.getBenodigdhedenLijst()){
			Benodigdheid nieuweBenodigdheid = benodigdheidService.geefBenodigdheidPerId(benodigdheid.getId());
			nieuweBenodigdheden.add(nieuweBenodigdheid);
		}
		voorstel.setBenodigdhedenLijst(nieuweBenodigdheden);
		this.voorstelService.slaVoorstelOp(voorstel);
	}

	@PostMapping("voorstel/voegSprekerAanVoorstelToe/{id}")
	public void voegSprekerAanVoorstelToe(@PathVariable long id, @RequestBody Voorstel voorstel){
		Spreker spreker1 = new Spreker();
		spreker1.setVoornaam(voorstel.getVoornaam());
		spreker1.setAchternaam(voorstel.getAchternaam());
		spreker1.setEmail(voorstel.geteMail());
		spreker1.setRol("s");
		voorstelService.slaVoorstelEnSprekerOp(voorstel, spreker1);
	}

	@PostMapping("voorstel/voegBenodigdheidAanVoorstelToe/{voorstelid}/{benodigdheidid}")
	public void voegBenodigdheidAanVoorstelToe(@PathVariable("voorstelid") int voorstelid, @PathVariable("benodigdheidid") int benodigdheidid){
		Benodigdheid benodigdheid = benodigdheidService.geefBenodigdheidPerId(benodigdheidid);
		voorstelService.findById(voorstelid).getBenodigdhedenLijst().add(benodigdheid);
	}

	@GetMapping("voorstel/geefBenodigdhedenPerVoorstel/{voorstelid}")
	public List<Benodigdheid> geefBenodigdhedenPerVoorstel(@PathVariable("voorstelid") int voorstelid){
		Voorstel huidigVoorstel = voorstelService.findById(voorstelid);
		return huidigVoorstel.getBenodigdhedenLijst();
	}

}
