package nl.topicus.topiconfbackend.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.topicus.topiconfbackend.domain.Aanvraag;

@Service
public class AanvraagService {

	
	@Autowired
	AanvraagRepository ar;

	public Aanvraag toevoegenAanvraag(Aanvraag aanvraag) {
		return ar.save(aanvraag);
		
	}

	public Iterable<Aanvraag> bekijkAanvraag() {
		return ar.findAll();
	}
	public Aanvraag findById(long id){
		 return ar.findById(id).get();
	}

	public void delete(long id) {
		ar.deleteById(id);
		
	}
}
