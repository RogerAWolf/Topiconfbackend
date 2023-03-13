package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Spreker;


@Service
public class SprekerService {

	@Autowired
	SprekerRepository ar;

	public Spreker toevoegenSpreker(Spreker spreker) {
		return ar.save(spreker);
		
	}

	public Iterable<Spreker> bekijkSpreker() {
		return ar.findAll();
	}

	public Spreker findById(long id){

		 return ar.findById(id).get();
	}

	
	}