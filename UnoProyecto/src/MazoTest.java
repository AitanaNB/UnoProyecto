package org.pmoo.proyecto;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazoTest {
    private Mazo mazo;

    @Before
    public void setUp() throws Exception {
        mazo = Mazo.getMazo(); // Obtener la misma instancia de Mazo en todos los tests
        mazo.inicializarMazo(); // Inicializar el mazo antes de cada prueba
    }

    @After
    public void tearDown() throws Exception {
        
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
}