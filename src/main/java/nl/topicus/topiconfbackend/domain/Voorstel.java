package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Voorstel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Benodigdheid> benodigdhedenLijst;
    private String voornaam;
    private String achternaam;
    private String onderwerp;
    private String samenvatting;
    private String status = "ongezien";
    private String eMail;
    private boolean isVeranderd;
    private String extraOpmerkingen;
    private String tijdsduur;
    private String maximaleCapaciteit;
    @OneToOne
    private Categorie categorie;
    @OneToOne
    private Spreker spreker;

    public List<Benodigdheid> getBenodigdhedenLijst() {
        return benodigdhedenLijst;
    }

    public void setBenodigdhedenLijst(List<Benodigdheid> benodigdhedenLijst) {
        this.benodigdhedenLijst = benodigdhedenLijst;
    }

    public String getExtraOpmerkingen() {
        return extraOpmerkingen;
    }

    public void setExtraOpmerkingen(String extraOpmerkingen) {
        this.extraOpmerkingen = extraOpmerkingen;
    }

    public boolean isVeranderd() {
        return isVeranderd;
    }

    public void setVeranderd(boolean veranderd) {
        isVeranderd = veranderd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getSamenvatting() {
        return samenvatting;
    }

    public void setSamenvatting(String samenvatting) {
        this.samenvatting = samenvatting;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @JsonIgnore
    public Spreker getSpreker() {
        return spreker;
    }
    
    @JsonIgnore
    public void setSpreker(Spreker spreker) {
        this.spreker = spreker;
    }

    public String getTijdsduur() {
        return tijdsduur;
    }

    public void setTijdsduur(String tijdsduur) {
        this.tijdsduur = tijdsduur;
    }
}