package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Persoon;


@Service
public class PersoonService {

	@Autowired
	PersoonRepository ar;

	public void toevoegenPersoon(Persoon persoon) {
		ar.save(persoon);
		
	}

	public Iterable<Persoon> bekijkPersoon() {
		return ar.findAll();
	}

	public Persoon findById(long id){

		 return ar.findById(id).get();
	}

	
	}