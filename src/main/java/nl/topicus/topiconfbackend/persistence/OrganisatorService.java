package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Organisator;

import java.util.List;


@Service
public class OrganisatorService {

    @Autowired
    OrganisatorRepository organisatorRepository;

    @Autowired
    PersoonRepository persoonRepository;

    public void slaOrganisatorOp(Organisator organisator) {
        organisatorRepository.save(organisator);
    }

    public Iterable<Organisator> geefAlleOrganisators() {
        return organisatorRepository.findAll();
    }

    public Organisator findById(long id) {
        return organisatorRepository.findById(id).get();
    }

    public Iterable<Persoon> geefAlleOrganisatorsPerEvenement(int id)
    {
        Iterable<Long> organisatorIds = organisatorRepository.geefAlleOrganisatorsVanDitEvenement(id);
        Iterable<Persoon> organisators = persoonRepository.findAllById(organisatorIds);
        return organisators;
    }

}