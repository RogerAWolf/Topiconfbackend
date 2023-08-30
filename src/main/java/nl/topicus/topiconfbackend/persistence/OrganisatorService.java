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

    @Autowired
    EvenementRepository evenementRepository;

    public void slaOrganisatorOp(Organisator organisator) {
        organisatorRepository.save(organisator);
    }

    public Iterable<Organisator> geefAlleOrganisators() {
        return organisatorRepository.findAll();
    }

    public Organisator findById(long id) {
        return organisatorRepository.findById(id).get();
    }

    public Iterable<Persoon> geefAlleOrganisatorsPerEvenement(long evenementid)
    {
        return evenementRepository.findById(evenementid).get().getPersoonLijst();
    }

}