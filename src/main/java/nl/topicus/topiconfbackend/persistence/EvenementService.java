package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.topicus.topiconfbackend.domain.Evenement;

@Service
public class EvenementService {
	@Autowired
	EvenementRepository er;
	
	public Iterable<Evenement> geefAlleEvenementen() {
		return er.findAll();
	}
	
	public void slaEvenementOp(Evenement e1) {
		er.save(e1);
	}
}
