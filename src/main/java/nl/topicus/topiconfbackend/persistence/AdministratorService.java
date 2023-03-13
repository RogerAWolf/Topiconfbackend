package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Administrator;


@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    public void slaAdministratorOp(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    public Iterable<Administrator> geefAlleAdministrators() {
        return administratorRepository.findAll();
    }

    public Administrator geefAdministratorPerId(long id) {
        return administratorRepository.findById(id).get();
    }


}