package nl.topicus.topiconfbackend.domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Presentatie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany
	private List<Spreker> sprekerList;

	@OneToOne
	private Track track;

	private String onderwerp;
	private String samenvatting;
	private int tijdsduur;
	private String faciliteiten;
	
	
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
	public String getSamenvatting() {
		return samenvatting;
	}
	public void setSamenvatting(String samenvatting) {
		this.samenvatting = samenvatting;
	}
	public int getTijdsduur() {
		return tijdsduur;
	}
	public void setTijdsduur(int tijdsduur) {
		this.tijdsduur = tijdsduur;
	}
	public String getFaciliteiten() {
		return faciliteiten;
	}
	public void setFaciliteiten(String faciliteiten) {
		this.faciliteiten = faciliteiten;
	}
	
	public List<Spreker> getSprekerList() {
		return sprekerList;
	}
	public void setSprekerList(List<Spreker> sprekerList) {
		this.sprekerList = sprekerList;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
}
