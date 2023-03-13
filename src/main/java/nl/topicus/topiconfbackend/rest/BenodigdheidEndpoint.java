package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import nl.topicus.topiconfbackend.persistence.BenodigdheidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BenodigdheidEndpoint {

    @Autowired
    BenodigdheidService bs;

    @GetMapping("benodigdheid/geefAlleBenodigdheden")
    public Iterable<Benodigdheid> geefAlleBenodigdheden(){
        return bs.geefAlleBenodigdheden();
    }

    @PostMapping("benodigdheid/voegBenodigdheidToe")
    public void voegBenodigdheidToe(@RequestBody Benodigdheid benodigdheid){
        bs.slaBenodigdheidOp(benodigdheid);
    }

    @DeleteMapping("benodigdheid/verwijderBenodigdheid/{benodigdheidid}")
    public void verwijderBenodigdheid(@PathVariable("benodigdheidid") int benodigdheidid){
        bs.verwijderBenodigdheid(benodigdheidid);
    }

}
