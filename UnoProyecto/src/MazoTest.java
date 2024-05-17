package org.pmoo.proyecto;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazoTest {
    private Mazo mazo;
    private PilaDescarte descarte;
    Carta carta1, carta2, carta3;
    @Before
    public void setUp() throws Exception {
        mazo = Mazo.getMazo(); // Obtener la misma instancia de Mazo en todos los tests
        descarte= PilaDescarte.getPilaDescarte();
        mazo.inicializarMazo(); // Inicializar el mazo antes de cada prueba
        carta1= new CartaNum("Amarillo",4);
		carta2= new CartaNum("Amarillo",3);
		carta3= new CartaNum("Amarillo",2);
    }

    @After
    public void tearDown() throws Exception {
        mazo.vaciarMazo();
    }
    
    @Test
    public void testInicializarMazo() 
    {
        try 
        {
			assertEquals(88, mazo.contarCartas());
		} catch (NoHayMasCartasException e) 
        {
			fail("Ha saltado una excepcion no debida");
		}
        // Otros casos de prueba...
    }

    @Test
    public void testContarCartas() 
    {
        try 
        {
			assertEquals(88, mazo.contarCartas());
		} catch (NoHayMasCartasException e) 
        {
			fail("Ha saltado una excepcion no debida");
		}
    }
    

    @Test 
    //Caso 1: cuando el mazo queda una Ãºnica carta
    public void testQuitarCartasDelMazo_Caso1()
    {
    	try 
    	{
			while(mazo.contarCartas()>1)
			{
				mazo.quitarCartaDelMazo();
			}	
			assertEquals(1, mazo.contarCartas());
	    	Carta ultimaCarta = mazo.quitarCartaDelMazo();
	     	assertNotNull(ultimaCarta);
		} 
    	catch (NoHayMasCartasException e) 
    	{
			fail("Ha saltado una excepcion no debida");
		}
    }
    @Test
  //Caso 2: cuando el mazo queda multiples cartas
    public void testQuitarCartasDelMazo_Caso2()
    {
    	try 
    	{
	    	Carta unaCarta = mazo.quitarCartaDelMazo();
	    	assertEquals(87, mazo.contarCartas());
	    	assertNotNull(unaCarta);
    	}
    	catch (NoHayMasCartasException e)
    	{
    		fail("Ha saltado una excepcion no debida");
    	}
    }
    
    @Test
  //Caso 3: cuando el mazo se queda sin cartas, salta la excepcion
    public void testQuitarCartasDelMazo_Caso3()
    {
    	try
    	{
	    	while(mazo.contarCartas()>0)
	    	{
	    		Carta unaCarta=mazo.quitarCartaDelMazo();
	    		descarte.anadirCarta(unaCarta);
	    		//Al salir del while, el mazo estara vacio
	    	}
	    	mazo.quitarCartaDelMazo();
	    	//Cuando intentamos quitar una carta del mazo, se ejecutara el metodo moverCartaDesdePilaDescarte
	    	//que pasara todas las cartas de pila descarte, menos la ultima, al mazo. Despues de hacer eso
	    	//se quitara una carta.
	    	assertEquals(mazo.contarCartas(),86);
	    	fail("No ha saltado la excepcion");
    	}
    	catch (NoHayMasCartasException e)
    	{
    	}
    }
    @Test
    public void testAnadirCartasAlMazo()
    {
    	try
    	{
	    	Carta unaCarta= new CartaNum("Amarillo",4);
	    	mazo.anadirCartaAlMazo(unaCarta);
	    	assertEquals(mazo.contarCartas(),89);
    	}
    	catch(NoHayMasCartasException e)
    	{
    		fail("Ha saltado una excepcion no debida");
    	}
    }
    
    @Test
    //Caso 1: Se mezclan cartas de un mazo no vacio
    public void testMezclarCarta1()
    {
    	mazo.vaciarMazo();
    	mazo.anadirCartaAlMazo(carta1);
    	mazo.anadirCartaAlMazo(carta2);
    	mazo.anadirCartaAlMazo(carta3);
    	mazo.mezclarCarta();
    	try
    	{
    		assertEquals(mazo.contarCartas(),3);
    	}
    	catch (NoHayMasCartasException e)
    	{
    		fail("Ha saltado una excepcion no debida");
    	}
    }
    
    @Test
    //Caso 2: Se mezclan cartas de un mazo con una sola carta
    public void testMezclarCarta2()
    {
    	mazo.vaciarMazo();
    	mazo.anadirCartaAlMazo(carta1);
    	mazo.mezclarCarta();
    	try
    	{
    		assertEquals(mazo.contarCartas(),1);
    	}
    	catch (NoHayMasCartasException e)
    	{
    		fail("Ha saltado una excepcion no debida");
    	}
    }
    
    @Test
    //Caso 3: Se mezclan cartas de un mazo vacio
    public void testMezclarCarta3()
    {
    	mazo.vaciarMazo();
    	mazo.mezclarCarta();
    	try
    	{
    		assertEquals(mazo.contarCartas(),0);
    		fail("No ha saltado la excepcion esperada");
    	}
    	catch (NoHayMasCartasException e)
    	{
    	}
    }
}
