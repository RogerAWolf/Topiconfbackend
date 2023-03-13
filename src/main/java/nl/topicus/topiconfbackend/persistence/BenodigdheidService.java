package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Benodigdheid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenodigdheidService {

    @Autowired
    BenodigdheidRepository br;

    public Iterable<Benodigdheid> geefAlleBenodigdheden() {
        return br.findAll();
    }

    public void slaBenodigdheidOp(Benodigdheid benodigdheid){
        br.save(benodigdheid);
    }

    public Benodigdheid geefBenodigdheidPerId(long id){
        return br.findById(id).get();
    }

    public void verwijderBenodigdheid(long id){
        br.deleteById(id);
    }
}
