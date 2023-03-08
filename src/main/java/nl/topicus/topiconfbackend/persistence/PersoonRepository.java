package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Persoon;

@Component
public interface PersoonRepository extends CrudRepository<Persoon, Long>{

}

