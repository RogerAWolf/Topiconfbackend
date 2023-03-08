package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Presentatie;


@Service
public class PresentatieService {

	@Autowired
	PresentatieRepository ar;

	public void toevoegenPresentatie(Presentatie presentatie) {
		ar.save(presentatie);
		
	}

	public Iterable<Presentatie> bekijkPresentatie() {
		return ar.findAll();
	}

	public Presentatie findById(long id){

		 return ar.findById(id).get();
	}

	
	}