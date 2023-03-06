package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Voorstel;


@Service
public class VoorstelService {

	@Autowired
	VoorstelRepository vr;

	public void toevoegenVoorstel(Voorstel voorstel) {
		vr.save(voorstel);
		
	}

	public Iterable<Voorstel> bekijkVoorstel() {
		return vr.findAll();
	}

	public Voorstel findById(long id){

		 return vr.findById(id).get();
	}

	public void linkTrackAanVoorstel(){

	}
}
