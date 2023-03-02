package nl.topicus.topiconfbackend.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.topicus.topiconfbackend.domain.Voorstel;

@Service
public class VoorstelService {

	
	@Autowired
	VoorstelRepository ar;

	public void toevoegenVoorstel(Voorstel voorstel) {
		ar.save(voorstel);
		
	}

	public Iterable<Voorstel> bekijkVoorstel() {
		return ar.findAll();
	}
	public Voorstel findById(long id){
		 return ar.findById(id).get();
	}

}
