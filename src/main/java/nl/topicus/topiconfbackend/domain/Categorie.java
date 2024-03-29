package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "categorieLijst")
    private List<Evenement> evenementLijst;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Evenement> getEvenementLijst() {
        return evenementLijst;
    }

    public void setEvenementLijst(List<Evenement> evenementLijst) {
        this.evenementLijst = evenementLijst;
    }
}
