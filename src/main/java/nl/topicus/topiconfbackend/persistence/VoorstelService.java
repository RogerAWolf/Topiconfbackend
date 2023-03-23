package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Spreker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Voorstel;

@Service
public class VoorstelService {

	@Autowired
	VoorstelRepository voorstelRepository;

	@Autowired
	SprekerRepository sprekerRepository;

	@Autowired
	BenodigdheidRepository benodigdheidRepository;

	public void slaVoorstelOp(Voorstel voorstel) {
		this.voorstelRepository.save(voorstel);
	}

	public Iterable<Voorstel> geefAlleVoorstellen() {
		return this.voorstelRepository.findAll();
	}

	public Voorstel findById(long id){
		 return voorstelRepository.findById(id).get();
	}

	public void slaVoorstelEnSprekerOp(Voorstel voorstel, Spreker spreker) {
//		spreker.getVoorstelLijst().add(voorstel);                hier breekt het endpoint voegvoorstelaanevenementtoe af.
		voorstel.setSpreker(spreker);
		sprekerRepository.save(spreker);
		voorstelRepository.save(voorstel);
	}

}
