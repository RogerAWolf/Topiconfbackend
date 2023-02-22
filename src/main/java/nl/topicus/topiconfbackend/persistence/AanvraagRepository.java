package nl.topicus.topiconfbackend.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Aanvraag;

@Component
public interface AanvraagRepository extends CrudRepository<Aanvraag, Long>{

}
