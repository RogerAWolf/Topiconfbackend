package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Organisator;


@Service
public class OrganisatorService {

    @Autowired
    OrganisatorRepository organisatorRepository;

    public void slaOrganisatorOp(Organisator organisator) {
        organisatorRepository.save(organisator);
    }

    public Iterable<Organisator> geefAlleOrganisators() {
        return organisatorRepository.findAll();
    }

    public Organisator findById(long id) {
        return organisatorRepository.findById(id).get();
    }

}