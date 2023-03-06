package nl.topicus.topiconfbackend.domain;

import javax.persistence.*;

@Entity
public class Voorstel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	private Track track;

	private String voornaam;
	private String achternaam;
	private String onderwerp;
	private String eMail;
	private String status = "ongemarkeerd";

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
}

//Test comment
