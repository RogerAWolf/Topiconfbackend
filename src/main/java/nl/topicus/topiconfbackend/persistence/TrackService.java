package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public Iterable<Track> geefAlleTracks(){
        return trackRepository.findAll();
    }

    public void slaTrackOp(Track track){
        trackRepository.save(track);
    }

    public void verwijderTrack(long trackid) {
        trackRepository.deleteById(trackid);
    }

    public Track findById(long id) {
        return this.trackRepository.findById(id).get();
    }
}
