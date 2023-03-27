package nl.topicus.topiconfbackend.rest;

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
    
    @DeleteMapping("locatie/verwijderLocatie/{locatieid}")
    public void verwijderLocatie(@PathVariable("locatieid") int locatieid, @RequestParam("id") int id){
        Evenement evenement = evenementService.findById(id);
        Locatie locatie = locatieService.findById(locatieid);
        evenement.getLocatieLijst().remove(locatie);
        locatieService.verwijderLocatie(locatieid);
    }
}
