package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategorieRepository extends CrudRepository<Categorie, Long> {

}
