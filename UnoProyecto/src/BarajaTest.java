package org.pmoo.proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarajaTest 
{
	Baraja barajaPrueba, barajaPrueba2, barajaPrueba3;
	Carta carta1, carta2, carta3;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		carta1= new CartaNum("Amarillo",4);
		carta2= new CartaNum("Amarillo",3);
		carta3= new CartaNum("Amarillo",2);
		barajaPrueba= new Baraja();
		barajaPrueba2= new Baraja();
		barajaPrueba3= new Baraja();
		barajaPrueba2.anadir(carta1);
		barajaPrueba3.anadir(carta1);
		barajaPrueba3.anadir(carta2);
		barajaPrueba3.anadir(carta3);
		
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		barajaPrueba= new Baraja();
		barajaPrueba2= new Baraja();
	}

	@Test
	void testBaraja() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testAnadir1() 
	{
		//CASO 1: Anadir carta a una baraja vacia
		barajaPrueba.anadir(carta1);
		assertEquals(barajaPrueba.contar(), 1);
		
	}
	
	@Test
	void testAnadir2()
	{
		//CASO 2: Anadir carta a una baraja no vacia
		barajaPrueba2.anadir(carta2);
		assertEquals(barajaPrueba2.contar(),2);
	}

	@Test
	void testQuitar1() {
		//CASO 1: Quitar carta de una baraja vacia, no deberia poder.
		barajaPrueba.quitar(carta1);
		
	}
	
	@Test
	void testQuitar2() {
		//CASO 2: Quitar carta de una baraja con solo una carta
		barajaPrueba2.quitar(carta1);
		assertEquals(barajaPrueba2.contar(),0);	
	}
	
	@Test
	void testQuitar3() {
		//CASO 3: Quitar una carta que no esta en la baraja
		barajaPrueba2.quitar(carta3);
		assertEquals(barajaPrueba2.contar(),1);
	}

	@Test
	void testContar1() {
		//CASO 1: Contar cartas de una baraja vacia, da 0
		assertEquals(barajaPrueba.contar(),0);
	}
	
	@Test
	void testContar2() {
		//CASO 2: Contar cartas de una baraja no vacia
		assertEquals(barajaPrueba3.contar(),3);
	}
	
	@Test
	void testMostrarBaraja1() {
		//CASO 1: No imprime nada
		barajaPrueba.mostrarBaraja();
	}
	
	@Test
	void testMostrarBaraja2() {
		//CASO 2: Imprime la unica carta que hay en la baraja
		barajaPrueba2.mostrarBaraja();
	}
	
	@Test
	void testMostrarBaraja3() {
		//CASO 3: Imprime las multiples cartas que hay en la baraja
		barajaPrueba3.mostrarBaraja();
	}

	@Test
	void testObtenerCarta1() {
		//CASO 1: Baraja vacia
		assertEquals(barajaPrueba.obtenerCarta(0),null);
	}

	@Test
	//CASO 2: Obtener carta de una baraja con una sola carta
	void testObtenerCarta2() {
		assertEquals(barajaPrueba2.obtenerCarta(0),carta1);
	}
	
	@Test
	//CASO 3: Obtener carta de una baraja con multiples cartas
	void testObtenerCarta3() {
		assertEquals(barajaPrueba3.obtenerCarta(2),carta3);
	}
}
