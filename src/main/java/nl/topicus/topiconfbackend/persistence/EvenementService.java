package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.domain.Evenement;

@Service
public class EvenementService {
	@Autowired
	EvenementRepository er;

	@Autowired
	TrackRepository tr;

	@Autowired
	LocatieRepository lr;
	
	public Iterable<Evenement> geefAlleEvenementen() {
		return er.findAll();
	}
	
	public void slaEvenementOp(Evenement e1) {
		er.save(e1);
	}

	public Iterable<Voorstel> geefVoorstellenPerEvenement(Evenement evenement) {
		return evenement.getVoorstelList();
	}

	public Iterable<Track> geefTracksPerEvenement(Evenement evenement){
		return evenement.getTrackList();
	}

	public Iterable<Locatie> geefLocatiesPerEvenement(Evenement evenement) { 
		return evenement.getLocatieLijst(); 
	}
	
	public void verwijderEvenement(long eventid){
		er.deleteById(eventid);
	}

	public Evenement findById(long eventid){
		return er.findById(eventid).get();
	}

	public void slaEvenementEnTrackOp(Evenement event, Track track) {
		tr.save(track);
		event.getTrackList().add(track);
		er.save(event);
	}

	public void slaEvenementEnLocatieOp(Evenement event, Locatie locatie) {
		lr.save(locatie);
		event.getLocatieLijst().add(locatie);
		er.save(event);
	}

}
