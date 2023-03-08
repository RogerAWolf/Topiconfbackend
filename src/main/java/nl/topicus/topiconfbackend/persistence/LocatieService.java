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
        if(locatie == null) {
            return false;
        } else {
            locatieRepository.save(locatie);
            return true;
        }

        // Met het oog op de Testen, het gewenste gedrag van de methode
        // To do:
        // Locatie met negatieve ID mag niet worden opgeslagen

        // Uitvragen bij PO:
        // Slaan we een locatie zonder naam op?
        // Slaan we een locatie zonder capaciteit op?
        // Slaan we een locatie zonder description op?
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