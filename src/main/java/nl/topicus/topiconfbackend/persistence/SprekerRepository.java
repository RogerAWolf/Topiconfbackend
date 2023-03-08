package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Spreker;

@Component
public interface SprekerRepository extends CrudRepository<Spreker, Long>{

}