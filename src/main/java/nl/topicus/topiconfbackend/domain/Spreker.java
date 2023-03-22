package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Spreker extends Persoon {

    @OneToMany
    private List<Voorstel> voorstelLijst;

    public List<Voorstel> getVoorstelLijst() {
        return voorstelLijst;
    }

    public void setVoorstelLijst(List<Voorstel> voorstelLijst) {
        this.voorstelLijst = voorstelLijst;
    }
}

