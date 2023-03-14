package nl.topicus.topiconfbackend.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.topicus.topiconfbackend.domain.Categorie;
import nl.topicus.topiconfbackend.domain.Voorstel;
import nl.topicus.topiconfbackend.persistence.CategorieService;
import nl.topicus.topiconfbackend.persistence.VoorstelService;

public class VoorstelEndPointIT {
	
	private VoorstelEndPoint voorstelEndPoint;
	private VoorstelService voorstelService;
	private CategorieService categorieService;
	
	@BeforeEach
	public void mocks() {
		voorstelService = mock(VoorstelService.class);
		categorieService = mock(CategorieService.class);
		voorstelEndPoint = new VoorstelEndPoint();
	}
	
	@Test
	public void testToevoegenVoorstel() {
		
		//Given
		Voorstel voorstel = new Voorstel();
		voorstel.setOnderwerp("Test Voorstel");
		Categorie categorie = new Categorie();
		categorie.setName("Test Categorie");
		when(categorieService.findById(1)).thenReturn(categorie);
		
		//When
		voorstelEndPoint.slaVoorstelOp(voorstel, 1);
		
		//Then
		assertEquals(categorie, voorstel.getCategorie());
	}
	
	@Test
	public void testGeefAlleVoorstellen() {
		
		//Given
		List<Voorstel> voorstellen = new ArrayList<>();
		voorstellen.add(new Voorstel());
		voorstellen.add(new Voorstel());
		
		//When
		Iterable<Voorstel> result = voorstelEndPoint.geefAlleVoorstellen();
		
		//Then
		assertEquals(voorstellen, result);
	}
	
	@Test
	public void testGetVoorstelByID() {
		
		//Given
		long id = 1;
		Voorstel verwachteVoorstel = new Voorstel();
		verwachteVoorstel.setId(id);
		when(voorstelService.findById(id)).thenReturn(verwachteVoorstel);
		
		//When
		Voorstel result = voorstelEndPoint.geefVoorstelPerId(id);
		
		//Them
		assertEquals(verwachteVoorstel, result);
	}
	
	@Test
	public void testSelecterenEnUpdate() {
		
		//Given
		long id = 1;
		Voorstel voorstel = new Voorstel();
		voorstel.setId(id);
		
		//When
		voorstelEndPoint.updateVoorstel(id, voorstel);
		
		//Then
		verify(voorstelService).slaVoorstelOp(voorstel);
	}
	
	@Test
	public void testToevoegenSprekerBijVoorstel() {
		
		//Given
		Voorstel voorstel = new Voorstel();
		voorstel.seteMail("test@example.com");
		
		//When
		voorstelEndPoint.voegSprekerAanVoorstelToe(1, voorstel);
		
		//Then
		Voorstel verwachteVoorstel = new Voorstel();
		verwachteVoorstel.setOnderwerp(voorstel.getOnderwerp());
		verwachteVoorstel.seteMail(voorstel.geteMail());
		verwachteVoorstel.setSamenvatting(voorstel.getSamenvatting());
	}
	
	
	}


