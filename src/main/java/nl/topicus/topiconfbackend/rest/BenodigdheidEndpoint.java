package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import nl.topicus.topiconfbackend.persistence.BenodigdheidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BenodigdheidEndpoint {

    @Autowired
    BenodigdheidService benodigdheidService;

    @GetMapping("benodigdheid/geefBenodigdheidPerId/{benodigdheidid}")
    public Benodigdheid geefBenodigdheidPerId(@PathVariable("benodigdheidid") int benodigdheidid){
        return benodigdheidService.geefBenodigdheidPerId(benodigdheidid);
    }

    @GetMapping("benodigdheid/geefAlleBenodigdheden")
    public Iterable<Benodigdheid> geefAlleBenodigdheden(){
        return benodigdheidService.geefAlleBenodigdheden();
    }

    @PostMapping("benodigdheid/slaBenodigdheidOp")
    public void slaBenodigdheidOp(@RequestBody Benodigdheid benodigdheid){
        benodigdheidService.slaBenodigdheidOp(benodigdheid);
    }

    @DeleteMapping("benodigdheid/verwijderBenodigdheid/{benodigdheidid}")
    public void verwijderBenodigdheid(@PathVariable("benodigdheidid") int benodigdheidid){
        benodigdheidService.verwijderBenodigdheid(benodigdheidid);
    }


}
