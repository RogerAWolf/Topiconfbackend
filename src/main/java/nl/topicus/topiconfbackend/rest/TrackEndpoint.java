package nl.topicus.topiconfbackend.rest;

import nl.topicus.topiconfbackend.domain.Track;
import nl.topicus.topiconfbackend.persistence.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackEndpoint {

    @Autowired
    private TrackService trackService;

    @GetMapping("track/geefAlleTracks")
    public Iterable<Track> geefAlleTracks(){
        System.out.println("retrieve");
        return trackService.geefAlleTracks();
    }

    @PostMapping("track/voegTrackToe")
    public void slaTrackOp(@RequestBody Track track){
        System.out.println("create");
        trackService.slaTrackOp(track);
    }

    @GetMapping("track/geefTrackPerID/{trackid}")
    public Track geefTrackPerID(@PathVariable("trackid") int trackid){
        return trackService.findById(trackid);
    }

    @DeleteMapping("track/verwijderTrack/{trackid}")
    public void verwijderTrack(@PathVariable("trackid") int trackid){
        System.out.println("delete");
        trackService.verwijderTrack(trackid);
    }


}
