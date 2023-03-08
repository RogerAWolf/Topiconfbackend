package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.persistence.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategorieEndpoint {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("categorie/geefAlleCategorieen")
    public Iterable<Categorie> geefAlleCategorieen(){
        System.out.println("retrieve");
        return categorieService.geefAlleCategorieen();
    }

    @PostMapping("categorie/voegCategorieToe")
    public void slaCategorieOp(@RequestBody Categorie categorie){
        System.out.println("create");
        categorieService.slaCategorieOp(categorie);
    }

    @GetMapping("categorie/geefCategoriePerID/{categorieid}")
    public Categorie geefCategoriePerID(@PathVariable("categorieid") int categorieid){
        return categorieService.findById(categorieid);
    }

    @DeleteMapping("categorie/verwijderCategorie/{categorieid}")
    public void verwijderCategorie(@PathVariable("categorieid") int categorieid){
        System.out.println("delete");
        categorieService.verwijderCategorie(categorieid);
    }


}
