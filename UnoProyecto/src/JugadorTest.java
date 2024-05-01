package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadorTest {

	Jugador unJugador;
	PilaDescarte pDescarte;
	Mazo mazo;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	
	@BeforeEach
	void setUp() throws Exception {
		unJugador = new Jugador("Pepe");
		pDescarte = PilaDescarte.getPilaDescarte();
		mazo=Mazo.getMazo();
		carta1 = new CartaNum("Amarillo",3);
		carta2 = new CartaNum("Rojo",0);
		carta3 = new CartaNum("Azul",4);
		carta4 = new CartaNum("Rojo",4);
		carta5 = new CartaEsp("Azul");
		carta6 = new CartaEsp("Rojo");
	}

	@AfterEach
	void tearDown() throws Exception {
		unJugador = new Jugador("Pepe");
		mazo.vaciarMazo();
		pDescarte.vaciar();
	}

	@Test
	void testVerCartas() {
		unJugador.agregarCartaAMano(carta1);
		unJugador.agregarCartaAMano(carta2);
		unJugador.agregarCartaAMano(carta3);
		unJugador.agregarCartaAMano(carta4);
		unJugador.agregarCartaAMano(carta5);
		unJugador.verCartas();
	}

	@Test
	//CASO 1: GENERAL, se intenta robar 1 carta del mazo, y al no poder jugar la carta robada, se roba otra mas
	//y se comprueba el numero de cartas que queda en Mazo, y la baraja del jugador.
	void testRobarCarta() {
		
		mazo.anadirCartaAlMazo(carta1);
		mazo.anadirCartaAlMazo(carta2);
		mazo.anadirCartaAlMazo(carta3);
		pDescarte.anadirCarta(carta1);
		unJugador.robarCarta();
		//Se roban las cartas: carta3 y carta2, ninguna de las dos jugables
		//Por lo que la baraja del jugador tendra 2 cartas, y el mazo se quedara con 1 carta
		assertEquals(unJugador.barajalong(),2);
		assertEquals(mazo.contarCartas(),1);
	}

	@Test
	//CASO 1: El jugador tiene una carta en su baraja, por lo tanto tiene que saltar el mensaje 
	void testGritarUno1() {
		unJugador.agregarCartaAMano(carta1);
		unJugador.gritarUno();
	}
	
	@Test
	//CASO 2: El jugador no tiene solo una carta en su baraja, por lo tanto no salta ningun mensaje
	void testGritarUno2() {
		unJugador.agregarCartaAMano(carta1);
		unJugador.agregarCartaAMano(carta2);
		unJugador.gritarUno();
	}
	

	@Test
	//CASO 1: Se selecciona una carta valida, y posicion valida. Se elimina la carta de la baraja del jugador
	//y se añade a la pila descarte
	void testUsarCarta1() {
		ArrayList<Carta> listaP = new ArrayList<Carta>(); //creacion de lista auxiliar para la prueba
		listaP.add(carta2);
		listaP.add(carta6);
		pDescarte.anadirCarta(carta2);
		unJugador.agregarCartaAMano(carta1);
		unJugador.agregarCartaAMano(carta2);
		unJugador.agregarCartaAMano(carta3);
		unJugador.agregarCartaAMano(carta4);
		unJugador.agregarCartaAMano(carta5);
		unJugador.agregarCartaAMano(carta6);
		unJugador.usarCarta(5); //Se juega la carta6 ya que se tiene en cuenta la pos0
		
		pDescarte.anadirCarta(carta4);
		assertEquals(listaP,pDescarte.obtenerCartasSinUltima()); //Se compara la lista que tiene las cartas:
		//carta2 y carta6, con la lista pDescarte sin la ultima  carta (una cualquiera), que deberia tener
		//las cartas: carta2 y carta6
	}
	
	@Test
	//CASO 2: Se selecciona una carta no jugable, se tiene que robar una carta del mazo
	//y al no ser jugable, roba otra carta mas
	void testUsarCarta2() {
		mazo.anadirCartaAlMazo(carta3);
		mazo.anadirCartaAlMazo(carta4);
		pDescarte.anadirCarta(carta1);
		unJugador.agregarCartaAMano(carta4);
		unJugador.agregarCartaAMano(carta5);
		unJugador.agregarCartaAMano(carta6);
		unJugador.usarCarta(2); //Se juega la carta6 ya que se tiene en cuenta la pos0
		//Al no ser una carta valida para jugar, se roba una carta del mazo, y como ninguna de las cartas
		//del mazo es valida para jugar, se vuelve a robar otra vez, y se termina el turno, por lo tanto,
		//el jugador ahora deberia tener una baraja de 3+2 cartas.
		assertEquals(unJugador.barajalong(),5);
	}
	
	@Test
	//CASO 3: Se selecciona una carta no jugable, se tiene que robar una carta del mazo
	//y al ser jugable, la juega y termina el turno.
	void testUsarCarta3() {
		mazo.anadirCartaAlMazo(carta4);
		mazo.anadirCartaAlMazo(carta2);
		pDescarte.anadirCarta(carta4);
		unJugador.agregarCartaAMano(carta1);
		unJugador.usarCarta(0); //Se juega la carta1 ya que se tiene en cuenta la pos0
		//Al no ser una carta valida para jugar, se roba una carta del mazo, y como se roba una carta jugable
		//la juega, y termina el turno. Por lo que la baraja  del jugador solo tendra 1 carta, y la pila Descarte
		//tendra una carta mas.
		assertEquals(unJugador.barajalong(),1);
		assertEquals(pDescarte.longitud(),2);
	}

	@Test
	//CASO 1: Agregar 1 carta a una baraja vacia
	void testAgregarCartaAMano1() {
		unJugador.agregarCartaAMano(carta1);
		assertEquals(unJugador.barajalong(),1);
	}
	
	@Test
	//CASO 2: Agregar 1 carta a una baraja no vacia
	void testAgregarCartaAMano2() {
		unJugador.agregarCartaAMano(carta1);
		unJugador.agregarCartaAMano(carta2);
		assertEquals(unJugador.barajalong(),2);
	}

	@Test
	//CASO 1: El jugador tiene 0 cartas en su baraja, por lo tanto ha ganado, y el metodo devuelve true
	void testHaGanado1() {
		assertTrue(unJugador.haGanado());
	}

	@Test
	//CASO 2: El jugador tiene cartas en su baraja, por lo tanto no ha ganado, y el meteodo devuelve false
	void testHaGanado2() {
		unJugador.agregarCartaAMano(carta1);
		unJugador.agregarCartaAMano(carta2);
		assertFalse(unJugador.haGanado());
	}

}
