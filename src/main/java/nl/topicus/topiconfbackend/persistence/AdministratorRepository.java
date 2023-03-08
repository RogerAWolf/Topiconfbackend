package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Administrator;

@Component
public interface AdministratorRepository extends CrudRepository<Administrator, Long>{

}