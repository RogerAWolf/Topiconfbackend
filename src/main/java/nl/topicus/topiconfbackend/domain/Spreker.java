package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Spreker extends Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "sprekers_voorstellen",
            joinColumns = @JoinColumn(name = "spreker_id"),
            inverseJoinColumns = @JoinColumn(name = "voorstel_id"))
    private List<Voorstel> voorstelLijst;

    @OneToOne
    private Voorstel voorstel;

    public Voorstel getVoorstel() {
        return voorstel;
    }

    public void setVoorstel(Voorstel voorstel) {
        this.voorstel = voorstel;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public List<Voorstel> getVoorstelLijst() {
        return voorstelLijst;
    }

    public void setVoorstelLijst(List<Voorstel> voorstelLijst) {
        this.voorstelLijst = voorstelLijst;
    }
}

