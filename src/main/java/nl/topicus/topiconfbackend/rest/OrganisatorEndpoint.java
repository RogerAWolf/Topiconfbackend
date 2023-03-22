package nl.topicus.topiconfbackend.rest;

import java.util.List;
import java.util.Optional;

import nl.topicus.topiconfbackend.domain.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.topicus.topiconfbackend.domain.Organisator;
import nl.topicus.topiconfbackend.persistence.OrganisatorService;


@RestController
public class OrganisatorEndpoint {

	@Autowired
	OrganisatorService organisatorService;
	
	//add request to database
	 //fronted will make sure that all fields are filled
	
	@CrossOrigin
	@PostMapping("organisator/slaOrganisatorOp")
	public void slaOrganisatorOp(@RequestBody Organisator organisator) {
		organisatorService.slaOrganisatorOp(organisator);
	}
	
	@GetMapping("organisator/geefAlleOrganisators")
	public Iterable<Organisator> geefAlleOrganisators() {
		return organisatorService.geefAlleOrganisators();
	}
	
	//not able to use yet
	@CrossOrigin
	@PutMapping("organisator/updateOrganisator/{id}")
	public void updateOrganisator(@PathVariable long id, @RequestBody Organisator organisator) {
		organisatorService.slaOrganisatorOp(organisator);
	}

	@CrossOrigin
	@GetMapping("organisator/geefOrganisatorPerId/{id}")
	public Organisator geefOrganisatorPerId(@PathVariable long id){
		return organisatorService.findById(id);
	}


	@GetMapping("organisator/geefOrganisatorsPerEvenementId/{evenementid}")
	public Iterable<Persoon> geefOrganisatorsPerEvenement(@PathVariable("evenementid") int evenementid)
	{
		System.out.println(evenementid);
		return organisatorService.geefAlleOrganisatorsPerEvenement(evenementid);
	}

}