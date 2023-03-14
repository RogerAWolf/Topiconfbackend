package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Presentatie;


@Service
public class PresentatieService {

    @Autowired
    PresentatieRepository presentatieRepository;

    public void slaPresentatieOp(Presentatie presentatie) {
        presentatieRepository.save(presentatie);
    }

    public Iterable<Presentatie> geefAllePresentaties() {
        return presentatieRepository.findAll();
    }

    public Presentatie findById(long id) {
        return presentatieRepository.findById(id).get();
    }

}