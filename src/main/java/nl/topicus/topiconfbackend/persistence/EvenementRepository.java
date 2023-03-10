package nl.topicus.topiconfbackend.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Evenement;

@Component
public interface EvenementRepository extends CrudRepository <Evenement, Long> {
	List<Evenement> findEvenementsByNaam(String naam);
}
