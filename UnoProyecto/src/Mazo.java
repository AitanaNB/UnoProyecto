package org.pmoo.proyecto;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo //MAE que contiene todas las cartas
{
	private static Mazo miMazo= new Mazo();
	private ArrayList<Carta> lista;
	
	private Mazo()
	{
		this.lista = new ArrayList<Carta>();
		
	}
	public static Mazo getMazo()
	{
		return miMazo;
	}
	
	public void inicializarMazo() //crea la baraja de cartas
	{
		int i=0;
		do { 
			//añadir las cartas con números
			CartaNum estaCarta= new CartaNum("Rojo", i);
			miMazo.lista.add(estaCarta);
			miMazo.lista.add(estaCarta);
			//System.out.println("color"+estaCarta.getColor()+"Numero"+estaCarta.getNum());
			
			estaCarta= new CartaNum("Amarillo", i);
			miMazo.lista.add(estaCarta);
			miMazo.lista.add(estaCarta);
			
			estaCarta= new CartaNum("Verde", i);
			miMazo.lista.add(estaCarta);
			miMazo.lista.add(estaCarta);
			
			estaCarta= new CartaNum("Azul", i);
			miMazo.lista.add(estaCarta);
			miMazo.lista.add(estaCarta);
			
			i++;			
		}while (i<10);
		
		//añadir las cartas especiales
		i=0;
		do {
			CartaEsp estaEsp= new CartaEsp("Rojo");
			miMazo.lista.add(estaEsp);
			
			estaEsp= new CartaEsp("Amarillo");
			miMazo.lista.add(estaEsp);
			
			estaEsp= new CartaEsp("Verde");
			miMazo.lista.add(estaEsp);
			
			estaEsp= new CartaEsp("Azul");
			miMazo.lista.add(estaEsp);
			
			i++;
		} while (i<2);		
	}
	public void mezclarCarta()
	{
		Collections.shuffle(this.lista);
	}
	
	public Carta quitarCartaDelMazo()
	{
		if (this.lista.isEmpty()) 
		{
			moverCartaDesdePilaDescarte();
		}
		return this.lista.remove(this.lista.size() - 1);
	}
	
	public void anadirCartaAlMazo(Carta pCarta)
	{
		this.lista.add(pCarta);
	}
	
	public int contarCartas()
	{
		return this.lista.size();
	}

	/*Pasa todas las cartas de la pila de descartes 
	 menos la última jugada al mazo*/
	public void moverCartaDesdePilaDescarte() 
	{
		PilaDescarte pDescarte = PilaDescarte.getPilaDescarte();
		ArrayList<Carta> listaAMover = pDescarte.obtenerCartasSinUltima();
		for (int i=0; i<listaAMover.size(); i++)
		{
			Carta actual= listaAMover.get(i);
			anadirCartaAlMazo(actual);
		}
		
}

