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
	EvenementRepository evenementRepository;

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	LocatieRepository locatieRepository;

	@Autowired
	VoorstelRepository voorstelRepository;

	public Iterable<Evenement> geefAlleEvenementen() {
		return evenementRepository.findAll();
	}

	public void slaEvenementOp(Evenement evenement) {
		evenementRepository.save(evenement);
	}

	public Iterable<Voorstel> geefAlleVoorstellenPerEvenement(Evenement evenement) {
		return evenement.getVoorstelLijst();
	}

	public Iterable<Categorie> geefAlleCategorieenPerEvenement(Evenement evenement){
		return evenement.getCategorieLijst();
	}

	public Iterable<Locatie> geefAlleLocatiesPerEvenement(Evenement evenement) {
		return evenement.getLocatieLijst();
	}

	public void verwijderEvenement(long eventid){
		evenementRepository.deleteById(eventid);
	}

	public Evenement findById(long eventid){
		return evenementRepository.findById(eventid).get();
	}

	public void slaEvenementEnCategorieOp(Evenement event, Categorie categorie) {
		categorieRepository.save(categorie);
		event.getCategorieLijst().add(categorie);
		evenementRepository.save(event);
	}

	public void slaEvenementEnLocatieOp(Evenement event, Locatie locatie) {
		locatieRepository.save(locatie);
		event.getLocatieLijst().add(locatie);
		evenementRepository.save(event);
	}

	public void slaEvenementEnVoorstelOp(Evenement event, Voorstel voorstel) {
		voorstelRepository.save(voorstel);
		event.getVoorstelLijst().add(voorstel);
		evenementRepository.save(event);
	}

	public Iterable<Evenement> geefEvenementPerNaam(String naam) {
		return evenementRepository.findEvenementsByNaam(naam);
	}





}
