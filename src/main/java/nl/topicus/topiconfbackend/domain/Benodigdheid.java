package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Benodigdheid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "benodigdhedenLijst")
    List<Voorstel> benodigdheden;

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
}
