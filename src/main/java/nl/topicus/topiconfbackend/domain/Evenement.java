package nl.topicus.topiconfbackend.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
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
	
	
}
