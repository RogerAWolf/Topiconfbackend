package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BenodigdheidRepository extends CrudRepository<Benodigdheid, Long> {

}
