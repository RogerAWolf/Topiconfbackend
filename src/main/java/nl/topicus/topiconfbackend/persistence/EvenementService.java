package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import nl.topicus.topiconfbackend.domain.Categorie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.domain.Evenement;

@Service
public class EvenementService {
	@Autowired
	EvenementRepository er;

	@Autowired
	CategorieRepository tr;

	@Autowired
	LocatieRepository lr;

	@Autowired
	VoorstelRepository vr;

	public Iterable<Evenement> geefAlleEvenementen() {
		return er.findAll();
	}

	public void slaEvenementOp(Evenement e1) {
		er.save(e1);
	}

	public Iterable<Voorstel> geefVoorstellenPerEvenement(Evenement evenement) {
		return evenement.getVoorstelLijst();
	}

	public Iterable<Categorie> geefCategorieenPerEvenement(Evenement evenement){
		return evenement.getCategorieLijst();
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

	public void slaEvenementEnCategorieOp(Evenement event, Categorie categorie) {
		tr.save(categorie);
		event.getCategorieLijst().add(categorie);
		er.save(event);
	}

	public void slaEvenementEnLocatieOp(Evenement event, Locatie locatie) {
		lr.save(locatie);
		event.getLocatieLijst().add(locatie);
		er.save(event);
	}

	public void slaEvenementEnVoorstelOp(Evenement event, Voorstel voorstel) {
		vr.save(voorstel);
		event.getVoorstelLijst().add(voorstel);
		er.save(event);
	}

	public Iterable<Evenement> haalEvenementOpMetNaam(String naam) {
		return er.findEvenementsByNaam(naam);
	}

}
