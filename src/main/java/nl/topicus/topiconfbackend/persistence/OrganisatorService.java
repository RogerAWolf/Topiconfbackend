package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Organisator;


@Service
public class OrganisatorService {

	@Autowired
	OrganisatorRepository ar;

	public void toevoegenOrganisator(Organisator organisator) {
		ar.save(organisator);
		
	}

	public Iterable<Organisator> bekijkOrganisator() {
		return ar.findAll();
	}

	public Organisator findById(long id){

		 return ar.findById(id).get();
	}

	
	}

