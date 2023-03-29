package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.persistence.EvenementService;
import nl.topicus.topiconfbackend.persistence.LocatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocatieEndpoint {

    @Autowired
    private LocatieService locatieService;
    
    @Autowired
    private EvenementService evenementService;

    @GetMapping("locatie/geefAlleLocaties")
    public Iterable<Locatie> geefAlleLocaties(){
        return locatieService.geefAlleLocaties();
    }

    @PostMapping("locatie/slaLocatieOp")
    public void slaLocatieOp(@RequestBody Locatie locatie){
        locatieService.slaLocatieOp(locatie);
    }

    @DeleteMapping("locatie/verwijderLocatie/{evenementid}/{locatieid}")
    public void verwijderLocatie(@PathVariable("evenementid") int evenementid, @PathVariable("locatieid") int locatieid){
        Evenement evenement = evenementService.findById(evenementid);
        Locatie teVerwijderenLocatie = locatieService.findById(locatieid);
        evenement.getLocatieLijst().remove(teVerwijderenLocatie);
        locatieService.verwijderLocatie(locatieid);
        evenementService.slaEvenementOp(evenement);
    }
}
