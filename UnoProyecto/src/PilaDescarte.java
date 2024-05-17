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
		int longitud= this.lista.size();
		ArrayList<Carta> listaSinUlt = new ArrayList<Carta>();
		for (int i=0; i<longitud-1; i++)
		{
			listaSinUlt.add(lista.get(1));
			this.lista.remove(1);
		}
		return listaSinUlt;
	}

	public void vaciar()
	{
		this.lista=new ArrayList<Carta>();
	}
	
	public int longitudPDescarte()
	{
		return this.lista.size();
	}
}
