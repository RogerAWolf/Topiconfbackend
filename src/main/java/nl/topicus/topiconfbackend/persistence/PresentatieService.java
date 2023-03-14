package nl.topicus.topiconfbackend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.topicus.topiconfbackend.domain.Presentatie;


@Service
public class PresentatieService {

    @Autowired
    PresentatieRepository presentatieRepository;


    public boolean slaPresentatieOp(Presentatie presentatie) {
        if (presentatie == null) {
        	return false;
        } else {
        	this.presentatieRepository.save(presentatie);
        	return true;
        }
    }


    public Iterable<Presentatie> geefAllePresentaties() {
        return presentatieRepository.findAll();
    }

    public Presentatie findById(long id) {
        return presentatieRepository.findById(id).get();
    }

}