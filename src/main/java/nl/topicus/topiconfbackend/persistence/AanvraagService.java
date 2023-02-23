package nl.topicus.topiconfbackend.persistence;

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
}
