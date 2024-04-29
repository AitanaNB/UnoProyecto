package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazoTest {
	private Mazo miMazo;

	@BeforeEach
	void setUp() throws Exception {
		miMazo= Mazo.getMazo();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMazo() {
		fail("Not yet implemented");
	}

	@Test
	void testInicializarMazo() 
	{
		
		miMazo.inicializarMazo();
		
	}

}
