package org.pmoo.proyecto;

import static org.junit.Assert.*;

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
    public void testInicializarMazo() {
        assertEquals(88, mazo.contarCartas());
        // Otros casos de prueba...
    }

    @Test
    public void testContarCartas() {
        assertEquals(88, mazo.contarCartas());
    }

    @Test 
    //Caso 1: cuando el mazo queda una única carta
    public void testQuitarCartasDelMazo_Caso1()
    {
    	while(mazo.contarCartas()>1)
    	{
    		mazo.quitarCartaDelMazo();
    	}
    	assertEquals(1, mazo.contarCartas());
    	Carta ultimaCarta = mazo.quitarCartaDelMazo();
    	assertNotNull(ultimaCarta);
    }
    @Test
  //Caso 2: cuando el mazo queda multiples cartas
    public void testQuitarCartasDelMazo_Caso2()
    {
    	Carta unaCarta = mazo.quitarCartaDelMazo();
    	assertEquals(87, mazo.contarCartas());
    	assertNotNull(unaCarta);
    }
    @Test
  //Caso 3: cuando el mazo se queda sin cartas, deben pasarse todas menos la ultima de pila descartes
    public void testQuitarCartasDelMazo_Caso3()
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
    }
    @Test
    public void testAnadirCartasAlMazo()
    {
    	Carta unaCarta= new CartaNum("Amarillo",4);
    	mazo.anadirCartaAlMazo(unaCarta);
    	assertEquals(mazo.contarCartas(),89);
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
    	assertEquals(mazo.contarCartas(),3);
    }
    
    @Test
    //Caso 2: Se mezclan cartas de un mazo con una sola carta
    public void testMezclarCarta2()
    {
    	mazo.vaciarMazo();
    	mazo.anadirCartaAlMazo(carta1);
    	mazo.mezclarCarta();
    	assertEquals(mazo.contarCartas(),1);
    }
    
    @Test
    //Caso 3: Se mezclan cartas de un mazo vacio
    public void testMezclarCarta3()
    {
    	mazo.vaciarMazo();
    	mazo.mezclarCarta();
    	assertEquals(mazo.contarCartas(),0);
    }
}
