package nl.topicus.topiconfbackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organisator extends Persoon{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

}
