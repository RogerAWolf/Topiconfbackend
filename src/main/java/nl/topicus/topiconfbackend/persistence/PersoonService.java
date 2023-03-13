package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Persoon;


@Service
public class PersoonService {

	@Autowired
	PersoonRepository persoonRep;

	public boolean toevoegenPersoon(Persoon persoon) {
		if (persoon == null) {
			return false;
		} else {
			this.persoonRep.save(persoon);
			return true;
		}
		
	}

	public Iterable<Persoon> bekijkPersoon() {
		return persoonRep.findAll();
	}

	public Persoon findById(long id){

		 return persoonRep.findById(id).get();
	}

	
}
