package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.domain.Evenement;
import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.persistence.CategorieService;
import nl.topicus.topiconfbackend.persistence.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategorieEndpoint {

    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private EvenementService evenementService;
    
    @GetMapping("categorie/geefAlleCategorieen")
    public Iterable<Categorie> geefAlleCategorieen(){
        return categorieService.geefAlleCategorieen();
    }

    @PostMapping("categorie/slaCategorieOp")
    public void slaCategorieOp(@RequestBody Categorie categorie){
        categorieService.slaCategorieOp(categorie);
    }

    @GetMapping("categorie/geefCategoriePerId/{categorieid}")
    public Categorie geefCategoriePerId(@PathVariable("categorieid") int categorieid){
        return categorieService.findById(categorieid);
    }

    @DeleteMapping("categorie/verwijderCategorie/{evenementid}/{categorieid}")
    public void verwijderCategorie(@PathVariable("evenementid") int evenementid, @PathVariable("categorieid") int categorieid){
        Evenement evenement = evenementService.findById(evenementid);
        Categorie teVerwijderenCategorie = categorieService.findById(categorieid);
        evenement.getCategorieLijst().remove(teVerwijderenCategorie);
        categorieService.verwijderCategorie(categorieid);
        evenementService.slaEvenementOp(evenement);
    }

    @DeleteMapping("categorie/verwijderCategorie/{categorieid}")
    public void verwijderCategorie(@PathVariable("categorieid") long categorieid, @RequestParam("evenementid") long evenementid){
        Evenement evenement = evenementService.findById(evenementid);
        Categorie teVerwijderenCategorie = categorieService.findById(categorieid);
        evenement.getCategorieLijst().remove(teVerwijderenCategorie);
        categorieService.verwijderCategorie(categorieid);
        evenementService.slaEvenementOp(evenement);
    }
}
