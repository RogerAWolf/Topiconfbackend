package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Presentatie;

@Component
public interface PresentatieRepository extends CrudRepository<Presentatie, Long>{

}