package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;

@Entity
public class Spreker extends Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
}

