package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Spreker;


@Service
public class SprekerService {

	@Autowired
	SprekerRepository sprekerRepository;

	public void slaSprekerOp(Spreker spreker) {
		sprekerRepository.save(spreker);
	}

	public Iterable<Spreker> geefAlleSprekers() {
		return sprekerRepository.findAll();
	}

	public Spreker findById(long id){
		 return sprekerRepository.findById(id).get();
	}
}