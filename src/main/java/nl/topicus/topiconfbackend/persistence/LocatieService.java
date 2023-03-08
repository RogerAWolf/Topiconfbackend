package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.Locatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocatieService {

    @Autowired
    private LocatieRepository locatieRepository;

    public Iterable<Locatie> geefAlleLocaties() {
        return locatieRepository.findAll();
    }

    public Boolean slaLocatieOp(Locatie locatie) {
        locatieRepository.save(locatie);
        return true;
    }

    public Boolean verwijderLocatie(long locatieid) {
        if (locatieid < 0) {
            return false;
        } else if (locatieRepository.existsById(locatieid)) {
            locatieRepository.deleteById(locatieid);
            return true;
        } else {
            return false;
        }
    }

    public Locatie findById(long id) {
        return this.locatieRepository.findById(id).get();
    }
}