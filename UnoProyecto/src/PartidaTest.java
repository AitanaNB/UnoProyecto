package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartidaTest 
{
	Mazo mazo = Mazo.getMazo();
	Jugador j1 = new Jugador("J1");
	Jugador j2 = new Jugador("J2");
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//CASO1: Al momento de elegir la opcion, se escribe un caracter distinto a J o R, entonces salta 
	//NoEsOpcionException
	//Codigo adaptado para el caso de prueba del metodo JugarPartida() de la clase Partida 
	void testJugarPartida1()  {	
		try
		{
			Partida partida = Partida.getPartida();
			partida.jugarPartida();
			fail("No se ha detectado un NoEsOpcionException");
		}
		catch(NoEsOpcionException neoe)
		{
		//Se detecta una NoEsOpcionException, entonces la prueba ha ido bien
		}
		catch(Exception e)
		{
			fail("Se ha detectado otra excepcion");
		}
	}
	
	
	@Test
	//CASO 1: Se reparten cartas a los dos jugadores. Comprobar que sus barajas tienen el numero correcto
	//de cartas y que el mazo tiene menos cartas, 88-(el numero de cartas repartidas).
	void testRepartirCartas()  
	{
		try
		{
			Partida partida = Partida.getPartida();
			mazo.inicializarMazo();
			mazo.mezclarCarta();
			partida.repartirCartas(j1, 5);
			partida.repartirCartas(j2, 7);
			assertEquals(j1.longitudBaraja(),5); //El jugador 1 deberia tener 5 cartas tras haberselas repartido
			assertEquals(j2.longitudBaraja(),7); //El jugador 2 deberia tener 7 cartas tras haberselas repartido
			assertEquals(mazo.contarCartas(),76); //En el mazo deberian quedar 76 cartas ya que: 88 cartas que hay
			//tras inicializar el mazo -(5+7) cartas que se han repartido.
		}
		catch (NoHayMasCartasException e)
		{
		 fail("Ha saltado una excepcion");
		}
		catch (NoEsOpcionException e)
		{
			fail("Ha saltado una excepcion");
		}
	}
}
