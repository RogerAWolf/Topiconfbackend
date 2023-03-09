package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Voorstel;


@Service
public class VoorstelService {

	@Autowired
	VoorstelRepository voorstelRepository;

	public void toevoegenVoorstel(Voorstel voorstel) {
		this.voorstelRepository.save(voorstel);
	}

	public Iterable<Voorstel> bekijkAlleVoorstellen() {
		return this.voorstelRepository.findAll();
	}

	public Voorstel findById(long id){

		 return voorstelRepository.findById(id).get();
	}

}
