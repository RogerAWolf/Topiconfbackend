package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Persoon;


@Service
public class PersoonService {

	@Autowired
	PersoonRepository persoonRepository;

	public boolean slaPersoonOp(Persoon persoon) {
		if (persoon == null) {
			return false;
		} else {
			this.persoonRepository.save(persoon);
			return true;
		}
	}

	public Iterable<Persoon> geefAllePersonen() {
		return persoonRepository.findAll();
	}

	public Persoon findById(long id){
		 return persoonRepository.findById(id).get();
	}

}
