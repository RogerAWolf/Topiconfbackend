package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Organisator;

@Component
public interface OrganisatorRepository extends CrudRepository<Organisator, Long>{

}