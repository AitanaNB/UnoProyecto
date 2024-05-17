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
		assertTrue(pDescarte.longitudPDescarte()==0);
		pDescarte.anadirCarta(carta1);
		assertTrue(pDescarte.longitudPDescarte()==1);
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
