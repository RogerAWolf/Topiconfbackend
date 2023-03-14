package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Administrator;

@Service
public class AdministratorService {

	@Autowired
	AdministratorRepository ar;

	public void toevoegenAdministrator(Administrator administrator) {
		ar.save(administrator);
	}

	public Iterable<Administrator> bekijkAdministrator() {
		return ar.findAll();
	}

	public Administrator findById(long id){
		 return ar.findById(id).get();
	}
}