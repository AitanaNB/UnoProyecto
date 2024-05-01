package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {
	Carta carta1, carta2, carta3, carta4;
	PilaDescarte pDescarte= PilaDescarte.getPilaDescarte();
	
	@BeforeEach
	void setUp() throws Exception {
		carta1= new CartaNum("Amarillo",4);
		carta2= new CartaNum("Azul",4);
		carta3= new CartaNum("Azul",2);
		carta4= new CartaEsp("Azul");
	}
	@AfterEach
	void tearDown() throws Exception {
		pDescarte.vaciar();
	}

	@Test
	void testGetColor() {
		assertEquals(carta1.getColor(),"Amarillo");
		assertEquals(carta2.getColor(),"Azul");
		assertEquals(carta4.getColor(),"Azul");
	}

	@Test
	//CASO 1: Ultima carta jugada es de distinto color pero mismo numero de la carta que se quiere jugar
	void testPuedeUsarse1() {
		pDescarte.anadirCarta(carta1);
		assertTrue(carta2.puedeUsarse());
	}
	
	@Test
	//CASO 2: Ultima carta jugada es de mismo color pero distinto numero de la carta que se quiere jugar
	void testPuedeUsarse2() {
		pDescarte.anadirCarta(carta2);
		assertTrue(carta3.puedeUsarse());
	}
	
	@Test
	//CASO 3: Ultima carta jugada es de distinto color y distinto numero de la carta que se quiere jugar
	void testPuedeUsarse3() {
		pDescarte.anadirCarta(carta3);
		assertFalse(carta1.puedeUsarse());
	}

	@Test
	//CASO 4: Ultima carta jugada es carta numerica de mismo color de la carta especial que se quiere jugar.
	void testPuedeUsarse4() {
		pDescarte.anadirCarta(carta3);
		assertTrue(carta4.puedeUsarse());
	}
	
	@Test
	void testGetNumero() {
		assertEquals(carta1.getNumero(),4);
		assertEquals(carta3.getNumero(),2);
		assertEquals(carta4.getNumero(),-1);
	}

}
