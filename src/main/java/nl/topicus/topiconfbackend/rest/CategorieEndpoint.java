package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.domain.Evenement;
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

    @DeleteMapping("categorie/verwijderCategorie/{categorieid}")
    public void verwijderCategorie(@PathVariable("categorieid") int categorieid, @RequestParam("id") int id){
        Evenement evenement = evenementService.findById(id);
        Categorie categorie = categorieService.findById(categorieid);
        evenement.getCategorieLijst().remove(categorie);
        categorieService.verwijderCategorie(categorieid);
    }
}
