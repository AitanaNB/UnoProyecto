package org.pmoo.proyecto;

import java.util.ArrayList;

public class PilaDescarte 
{
	private ArrayList<Carta> lista;
	public static PilaDescarte miPilaDescarte = new PilaDescarte();
	
	public PilaDescarte() 
	{
		this.lista=new ArrayList<Carta>();
	}
	
	public void anadirCarta(Carta pCarta)
	{
		this.lista.add(pCarta);
	}
	
	public Carta obtenerUltimaCarta()
	{
		return this.lista.get(this.lista.size()-1);
	}
	
	
}
