package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocatieService {

    @Autowired
    LocatieRepository locatieRepository;

    public Iterable<Locatie> geefAlleLocaties(){
        return locatieRepository.findAll();
    }

    public void slaLocatieOp(Locatie locatie){
        locatieRepository.save(locatie);
    }

    public void verwijderLocatie(long locatieid) {
        locatieRepository.deleteById(locatieid);
    }

    public Locatie findById(long id) {
        return this.locatieRepository.findById(id).get();
    }
}