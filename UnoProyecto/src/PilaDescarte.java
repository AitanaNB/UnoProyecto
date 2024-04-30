package org.pmoo.proyecto;

import java.util.ArrayList;

public class PilaDescarte 
{
	private ArrayList<Carta> lista;
	public static PilaDescarte miPilaDescarte = new PilaDescarte();
	
	private PilaDescarte() 
	{
		this.lista=new ArrayList<Carta>();
	}
	public static PilaDescarte getPilaDescarte()
	{
		return miPilaDescarte;
	}
	
	public void anadirCarta(Carta pCarta)
	{
		this.lista.add(pCarta);
	}
	
	public Carta obtenerUltimaCarta()
	{
		return this.lista.get(this.lista.size()-1);
	}

	public ArrayList<Carta> obtenerCartasSinUltima()
	{
		ArrayList<Carta> listaSinUlt = new ArrayList<Carta>();
		for (int i=0; i<this.lista.size()-1; i++)
		{
			listaSinUlt.add(lista.get(i));
			this.lista.remove(i);
		}
		return listaSinUlt;
	}
	
}
