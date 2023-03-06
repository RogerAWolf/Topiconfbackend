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

    public void slaLocatieOp(Locatie locatie) {
        locatieRepository.save(locatie);
    }

    public String verwijderLocatie(long locatieid) {
        if (locatieid < 0) {
            return "U mag alleen een positieve waarde invullen";
        }
        if (locatieRepository.existsById(locatieid)) {
            locatieRepository.deleteById(locatieid);
            return "verwijderd";
        } else {
            return "Kan niet gevonden worden";
        }
    }

    public Locatie findById(long id) {
        return this.locatieRepository.findById(id).get();
    }
}