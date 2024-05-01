package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaDescarteTest {
	PilaDescarte pDescarte = PilaDescarte.getPilaDescarte();
	Carta carta1 = new CartaNum("Amarillo",3);
	Carta carta2 = new CartaNum("Rojo",0);
	Carta carta3 = new CartaNum("Azul",4);
	Carta carta4 = new CartaNum("Rojo",4);
	Carta carta5 = new CartaEsp("Azul");
	Carta carta6 = new CartaEsp("Rojo");
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		pDescarte.vaciar();
	}

	@Test
	//CASO 1: Anadir carta a una lista vacia
	void testAnadirCarta() {
		assertTrue(pDescarte.longitud()==0);
		pDescarte.anadirCarta(carta1);
		assertTrue(pDescarte.longitud()==1);
	}

	@Test
	//CASO 1: Obtener ultima carta de una lista no vacia
	void testObtenerUltimaCarta() {
		pDescarte.anadirCarta(carta1);
		pDescarte.anadirCarta(carta2);
		pDescarte.anadirCarta(carta3);
		assertEquals(pDescarte.obtenerUltimaCarta(),carta3);
	}

	@Test
	//CASO 1: Cartas numericas de mismo color y distinto numero, daria true
	void testPuedeUsarse1() {
		pDescarte.anadirCarta(carta2);
		assertTrue(pDescarte.puedeUsarse(carta4));
	}

	@Test
	//CASO 2: Cartas numericas de mismo numero y distinto color, daria true
	void testPuedeUsarse2() {
		pDescarte.anadirCarta(carta3);
		assertTrue(pDescarte.puedeUsarse(carta4));
	}
	
	@Test
	//CASO 3: Cartas numericas de mismo numero y color, daria true
	void testPuedeUsarse3() {
		pDescarte.anadirCarta(carta3);
		assertTrue(pDescarte.puedeUsarse(carta3));
	}
	
	@Test
	//CASO 4: Carta numerica y carta especial de mismo color, daria true
	void testPuedeUsarse4() {
		pDescarte.anadirCarta(carta3);
		assertTrue(pDescarte.puedeUsarse(carta5));
	}
	
	@Test
	//CASO 5: Carta especial y carta numerica de distinto color, daria false
	void testPuedeUsarse5() {
		pDescarte.anadirCarta(carta5);
		assertFalse(pDescarte.puedeUsarse(carta1));
	}

	@Test
	//CASO 6: Carta especial y carta especial de distinto color, daria true
	void testPuedeUsarse6() {
		pDescarte.anadirCarta(carta5);
		assertTrue(pDescarte.puedeUsarse(carta6));
	}

	@Test
	void testObtenerCartasSinUltima() {
		pDescarte.anadirCarta(carta1);
		pDescarte.anadirCarta(carta2);
		pDescarte.anadirCarta(carta3);
		pDescarte.anadirCarta(carta4);
		pDescarte.anadirCarta(carta5);
		ArrayList<Carta> lista= new ArrayList<Carta>();
		lista.add(carta1);
		lista.add(carta2);
		lista.add(carta3);
		lista.add(carta4);
		assertEquals(pDescarte.obtenerCartasSinUltima(),lista);
	}
}
