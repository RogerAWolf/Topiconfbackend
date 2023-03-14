package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenodigdheidService {

    @Autowired
    BenodigdheidRepository benodigdheidRepository;

    public Iterable<Benodigdheid> geefAlleBenodigdheden() {
        return benodigdheidRepository.findAll();
    }

    public void slaBenodigdheidOp(Benodigdheid benodigdheid) {
        benodigdheidRepository.save(benodigdheid);
    }

    public Benodigdheid geefBenodigdheidPerId(long id) {
        return benodigdheidRepository.findById(id).get();
    }

    public void verwijderBenodigdheid(long id) {
        benodigdheidRepository.deleteById(id);
    }
}
