package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Voorstel;

@Component
public interface VoorstelRepository extends CrudRepository<Voorstel, Long>{

}
