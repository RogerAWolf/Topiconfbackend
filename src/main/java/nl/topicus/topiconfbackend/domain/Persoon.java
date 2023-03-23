package nl.topicus.topiconfbackend.domain;

import nl.topicus.topiconfbackend.domain.security.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private enum Rol {
        SPREKER,
        ORGANISATOR,
        ADMINISTRATOR;
    }

    private String voornaam;
    private String achternaam;
    private String email;
    private String rol;  //s = spreker, o = organisator, a = administrator
    private String password;

    @ManyToMany(mappedBy = "persoonLijst")
    private List<Evenement> evenementenLijst;

    public long getId() {
        return id;
    }

    public List<Evenement> getEvenementenLijst() {
        return evenementenLijst;
    }

    public void setEvenementenLijst(List<Evenement> evenementenLijst) {
        this.evenementenLijst = evenementenLijst;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
