package nl.topicus.topiconfbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@OneToMany
	private List<Categorie> categorieLijst = new ArrayList<Categorie>();

	@OneToMany
	private List<Voorstel> voorstelLijst = new ArrayList<Voorstel>();

	@OneToMany
	private List<Locatie> locatieLijst = new ArrayList<Locatie>();

	@ManyToMany
	@JoinTable(
			name = "evenement_organisatorlijst",
			joinColumns = @JoinColumn(name = "evenement_id"),
			inverseJoinColumns = @JoinColumn(name = "persoon_id")
	)
	private List<Persoon> persoonLijst;

	@JsonIgnore
	public List<Persoon> getPersoonLijst() {
		return persoonLijst;
	}

	@JsonIgnore
	public void setPersoonLijst(List<Persoon> persoonLijst) {
		this.persoonLijst = persoonLijst;
	}

	private String naam;
	private String omschrijving;
	private LocalDateTime beginDatumTijd;
	private LocalDateTime eindDatumTijd;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public LocalDateTime getBeginDatumTijd() {
		return beginDatumTijd;
	}

	public void setBeginDatumTijd(LocalDateTime beginDatumTijd) {
		this.beginDatumTijd = beginDatumTijd;
	}

	public LocalDateTime getEindDatumTijd() {
		return eindDatumTijd;
	}

	public void setEindDatumTijd(LocalDateTime eindDatumTijd) {
		this.eindDatumTijd = eindDatumTijd;
	}

	@JsonIgnore
	public List<Categorie> getCategorieLijst() {
		return categorieLijst;
	}

	@JsonIgnore
	public void setCategorieLijst(List<Categorie> categorieLijst) {
		this.categorieLijst = categorieLijst;
	}

	@JsonIgnore
	public List<Voorstel> getVoorstelLijst() {
		return voorstelLijst;
	}

	@JsonIgnore
	public void setVoorstelLijst(List<Voorstel> voorstelLijst) {
		this.voorstelLijst = voorstelLijst;
	}

	public List<Locatie> getLocatieLijst() {
		return locatieLijst;
	}

	public void setLocatieLijst(List<Locatie> locatieLijst) {
		this.locatieLijst = locatieLijst;
	}

}
