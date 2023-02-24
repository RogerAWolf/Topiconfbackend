package nl.topicus.topiconfbackend.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocatieIT {

    private  Locatie locatie;

    // This constructor is invoked every time @Test annotated method is run
    public LocatieIT() {
        this.locatie = new Locatie();
    }

    @Test
    public void testGetAndSetId() {
        locatie.setId(10L);
        assertEquals(10L, locatie.getId());
    }

    @Test
    public void testSetAndGetName() {
        locatie.setName("Rudi");
        assertEquals("Rudi", locatie.getName());
    }

    @Test
    public void testSetAndGetDescription() {
        locatie.setDescription("Omschrijving");
        assertEquals("Omschrijving", locatie.getDescription());
    }

    @Test
    public void testSetAndGetCapacity() {
        locatie.setCapacity("100 Personen");
        assertEquals("100 Personen", locatie.getCapacity());
    }
}