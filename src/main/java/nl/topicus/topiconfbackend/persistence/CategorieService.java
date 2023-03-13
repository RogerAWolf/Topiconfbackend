package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Iterable<Categorie> geefAlleCategorieen() {
        return categorieRepository.findAll();
    }

    public void slaCategorieOp(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public void verwijderCategorie(long categorieid) {
        categorieRepository.deleteById(categorieid);
    }

    public Categorie findById(long id) {

        return this.categorieRepository.findById(id).get();
    }
}
