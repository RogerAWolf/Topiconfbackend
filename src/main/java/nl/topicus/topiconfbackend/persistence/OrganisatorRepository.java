package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.topicus.topiconfbackend.domain.Organisator;

import java.util.List;

@Component
public interface OrganisatorRepository extends CrudRepository<Organisator, Long>{
    @Query(value = "SELECT `persoon_id` FROM topiconfdb.evenement_organisatorlijst WHERE `evenement_id` = ?1", nativeQuery = true)
    List<Long> geefAlleOrganisatorsVanDitEvenement(int evenement_id);
}