package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voorstel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany
	private List<Benodigdheid> benodigdhedenLijst;

	private String naam;
	private String onderwerp;
	private String samenvatting;
	private String status = "ongemarkeerd";
	private String eMail;

	public boolean isVeranderd() {
		return isVeranderd;
	}

	public void setVeranderd(boolean veranderd) {
		isVeranderd = veranderd;
	}

	private boolean isVeranderd;

	@OneToOne
	private Categorie categorie;

	@OneToOne
	private Spreker spreker;

	
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

	public String getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public String getSamenvatting() {return samenvatting;}

	public void setSamenvatting(String samenvatting){this.samenvatting = samenvatting;}

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

	public Spreker getSpreker() {
		return spreker;
	}

	public void setSpreker(Spreker spreker) {
		this.spreker = spreker;
	}
}