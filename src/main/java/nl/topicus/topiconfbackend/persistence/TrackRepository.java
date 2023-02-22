package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrackRepository extends CrudRepository<Track, Long> {

}
