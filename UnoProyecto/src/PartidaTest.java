package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartidaTest {
	Mazo mazo = Mazo.getMazo();
	Jugador j1 = new Jugador("J1");
	Jugador j2 = new Jugador("J2");
	Jugador jActual;
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
	void testJugarPartida1() {
		String opcion="P"; //Supuesto caso de que se ha elegido un caracter distinto a J o R
		try {
		if (opcion.equals("J") || opcion.equals("j")) 
	    { 
			//(...) Codigo de jugar carta
	    } 
	    else if (opcion.equals("R") || opcion.equals("r")) 
	    { 
	    	//(...) Codigo de robar carta
	    } 
	    else //Al no haber introducido ni J ni R, salta la excepcion NoEsOpcionException
	    {
		System.out.println("No has introducido una de las opciones");
	       System.out.println("\nGAME OVER");
	       throw (new NoEsOpcionException());
	    }
		fail("Deberia haber saltado la excepcion NoEsOpcionException");
		}
		catch(NoEsOpcionException neoe) 
		{
			//Ha saltado, por lo que el caso de prueba es correcto
		}
		catch(Exception e)
		{
			fail("Salto otra excepcion que no es NoEsOpcionException");
		}
	}
	
	@Test
	//CASO2: Al momento de elegir cartas, se escribe un caracter de numero, entonces NO salta 
	//NumberFormatException, y el programa continuaria
	//linea de codigo 83 de la clase Partida, adaptado para caso de prueba
	
	void testJugarPartida3() {
		int posCarta;
		String input="3"; //Se ha introducido el caracter "3" al momento de seleccionar una posicion de la
		//baraja, entonces NO saltara una NumberFormatException y el programa continuara
		try 
		{
		posCarta = Integer.parseInt(input)-1;
		}
		catch(NumberFormatException nfe)
		{
			fail("Ha saltado una NumberFormatException");
		}
		catch(Exception e)
		{
			fail("Salto una excepcion");
		}
	}
	
	@Test
	//CASO3: Al momento de elegir cartas, se escribe un caracter que no es un integer, entonces salta 
	//NumberFormatException 
	//linea de codigo 83 de la clase Partida, adaptado para caso de prueba
	
	void testJugarPartida2() {
		int posCarta;
		String input="p"; //Se ha introducido el caracter "p" al momento de seleccionar una posicion de la
		//baraja, entonces saltara una NumberFormatException
		try 
		{
		posCarta = Integer.parseInt(input)-1;
		fail("No salto ninguna excepcion");
		}
		catch(NumberFormatException nfe)
		{
		}
		catch(Exception e)
		{
			fail("Salto una excepcion diferente");
		}
	}
	
	@Test
	//CASO4: Se elije la opcion J, jugar, por lo que se realizara las acciones que conllevan jugar
	//Codigo adaptado para el caso de prueba del metodo JugarPartida() de la clase Partida
	void testJugarPartida4() {
		String opcion="J"; //Supuesto caso de que se ha elegido "J", Jugar
		if (opcion.equals("J") || opcion.equals("j")) 
	    { 
			//(...) Codigo de jugar carta
	    } 
	    else if (opcion.equals("R") || opcion.equals("r")) 
	    { 
	    	fail("El metodo no hace lo que deberia");
	    } 
	    else 
	    {
	    	fail("El metodo no hace lo que deberia");
	    }
	}

	@Test
	//CASO5: Se elije la opcion R, robar, por lo que se realizara las acciones que conllevan robar
	//Codigo adaptado para el caso de prueba del metodo JugarPartida() de la clase Partida
	void testJugarPartida5() {
		String opcion="R"; //Supuesto caso de que se ha elegido "R", robar
		if (opcion.equals("J") || opcion.equals("j")) 
	    { 
			fail("El metodo no hace lo que deberia");
	    } 
	    else if (opcion.equals("R") || opcion.equals("r")) 
	    { 
	    	//(...) Codigo de robar carta
	    } 
	    else 
	    {
	    	fail("El metodo no hace lo que deberia");
	    }
	}
	
	@Test
	//CASO 1: Se reparten cartas a los dos jugadores. Comprobar que sus barajas tienen el numero correcto
	//de cartas y que el mazo tiene menos cartas, 88-(el numero de cartas repartidas).
	void testRepartirCartas() throws NoEsOpcionException 
	{
		Partida partida = Partida.getPartida();
		mazo.inicializarMazo();
		mazo.mezclarCarta();
		partida.repartirCartas(j1, 5);
		partida.repartirCartas(j2, 7);
		assertEquals(j1.barajalong(),5); //El jugador 1 deberia tener 5 cartas tras haberselas repartido
		assertEquals(j2.barajalong(),7); //El jugador 2 deberia tener 7 cartas tras haberselas repartido
		assertEquals(mazo.contarCartas(),76); //En el mazo deberian quedar 76 cartas ya que: 88 cartas que hay
		//tras inicializar el mazo -(5+7) cartas que se han repartido.
	}

	@Test
	//CASO 1: El jugador actual es el j1, por lo que despues de ejecutar el metodo, el jugador actual
	//pasara a ser el j2.
	//Codigo extraido de la linea 167 de la clase Partida, metodo: turnoJugador, adaptada para el caso de prueba.
	void testTurnoJugador1() throws NoEsOpcionException 
	{
		jActual=j1;
		if (j1.turnoTerminado())
		{
			if (jActual==j1)
			{
				jActual=j2;
			}
			else 
			{
				jActual=j1;	
			}
		}
		assertEquals(jActual,j2);
	}

	//CASO 2: El jugador actual es el j2, por lo que despues de ejecutar el metodo, el jugador actual
		//pasara a ser el j1.
		//Codigo extraido de la linea 167 de la clase Partida, metodo: turnoJugador adaptada para el caso de prueba.
		void testTurnoJugador2() throws NoEsOpcionException 
		{
			jActual=j2;
			if (j1.turnoTerminado())
			{
				if (jActual==j1)
				{
					jActual=j2;
				}
				else 
				{
					jActual=j1;	
				}
			}
			assertEquals(jActual,j1);
		}
}
