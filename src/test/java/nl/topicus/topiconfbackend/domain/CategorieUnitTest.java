package nl.topicus.topiconfbackend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CategorieUnitTest {
	
	@Test
	public void testCategorieName() {
		Categorie c = new Categorie();
		assertEquals("Categorieen", c.getName());
	}
	
	@Test
	public void testCategorieDescription() {
		Categorie c = new Categorie();
		assertEquals("Categorieen bstaan uit verschillende onderwerp", c.getDescription());
	}

}
