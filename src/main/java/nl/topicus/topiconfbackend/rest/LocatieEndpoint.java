package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.persistence.LocatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocatieEndpoint {

    @Autowired
    private LocatieService locatieService;

    @GetMapping("locatie/geefAlleLocaties")
    public Iterable<Locatie> geefAlleLocaties(){
        System.out.println("retrieve");
        return locatieService.geefAlleLocaties();
    }

    @PostMapping("locatie/voegLocatieToe")
    public void voegLocatieToe(@RequestBody Locatie locatie){
        System.out.println("create");
        locatieService.slaLocatieOp(locatie);
    }

    @DeleteMapping("locatie/verwijderLocatie/{locatieid}")
    public void verwijderLocatie(@PathVariable("locatieid") int locatieid){
        System.out.println("delete");
        locatieService.verwijderLocatie(locatieid);
    }
}
