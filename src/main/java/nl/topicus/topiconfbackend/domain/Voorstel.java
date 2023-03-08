package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;

@Entity
public class Voorstel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	private Categorie categorie;

	@OneToOne
	private Spreker spreker;

	private String onderwerp;
	private String status = "ongemarkeerd";
	private String eMail;
	private String samenvatting;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public String getSamenvatting() {return samenvatting;}

	public void setSamenvatting(String samenvatting){this.samenvatting = samenvatting;}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOnderwerp() {
		return onderwerp;
	}
	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	
}

//Test comment
