package org.pmoo.proyecto;

import java.util.ArrayList;
import java.util.Collections;


public class Mazo 
{
	private ArrayList<Carta> lista;
	private static Mazo miMazo = new Mazo();
	
	private Mazo()
	{
		this.lista=new ArrayList<Carta>();
	}
	
	public static Mazo getMazo() 
	{
		return miMazo;
	}
	
	public void inicializarMazo()
	{
		String[] colores = {"rojo", "azul", "verde", "amarillo"};
	    
		this.lista.clear(); //Limpia el mazo antes de añadir cartas
		
	    // Se añade cartas numeradas y cartas "Toma Dos" para cada color
	    for (String color : colores) {
	        // Agregar cartas numeradas
	        for (int numero = 0; numero <= 9; numero++) {
	            for (int i = 0; i < 2; i++) {
	                CartaNum cartaNumerada = new CartaNum(color, numero);
	                anadirCartaAlMazo(cartaNumerada);
	            }
	        }
	        
	        // Agregar cartas "Toma Dos"
	        for (int i = 0; i < 2; i++) {
	            CartaEsp cartaTomaDos = new CartaEsp(color);
	            anadirCartaAlMazo(cartaTomaDos);
	        }
	    }
	    mezclarCarta();
	}
	
	public void mezclarCarta()
	{
		Collections.shuffle(this.lista);
	}
	

	public Carta quitarCartaDelMazo() throws NoHayMasCartasException 
	{
		boolean todoCorrecto=false;
		do {
			try {
				this.contarCartas();
				todoCorrecto=true;
			}catch (NoHayMasCartasException nhmce) {
				System.out.println("************************");
				System.out.println("NoHayMasCartasException");
				System.out.println("\nNo hay cartas en el mazo");
				moverCartaDesdePilaDescarte();
				System.out.println("Moviendo cartas");
				System.out.println("************************");
				mezclarCarta();
				todoCorrecto=true;
			}
		} while(!todoCorrecto);
		if (!this.lista.isEmpty()) {
	        return this.lista.remove(this.lista.size() - 1);
	    } else {
	        throw new NoHayMasCartasException(); // Lanzar excepción si no hay cartas en el mazo
	    }
	}
	
	/*public Carta quitarCartaDelMazo()
	{
		if (this.lista.isEmpty()) 
		{
			moverCartaDesdePilaDescarte();
		}
		return this.lista.remove(this.lista.size() - 1);
	}*/
	
	public void anadirCartaAlMazo(Carta pCarta)
	{
		this.lista.add(pCarta);
	}
	
	public int contarCartas() throws NoHayMasCartasException
	{
		if (this.lista.size()==0)
		{
			throw (new NoHayMasCartasException());
		}
		
		return this.lista.size();
	}

	
	public void moverCartaDesdePilaDescarte()
	{
		PilaDescarte pDescarte = PilaDescarte.getPilaDescarte();
		ArrayList<Carta> listaAMover = pDescarte.obtenerCartasSinUltima();
		for (Carta actual: listaAMover)
		{
			anadirCartaAlMazo(actual);
		}
	}
}
