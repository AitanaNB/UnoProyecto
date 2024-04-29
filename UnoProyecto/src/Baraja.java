package org.pmoo.proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class Baraja 
{
	private ArrayList<Carta> lista;
	
	public Baraja()
	{
		this.lista=new ArrayList<Carta>();
	}
	
	public void anadir(Carta pCarta)
	{
		this.lista.add(pCarta);
	}
	
	public void quitar(Carta pCarta)
	{
		this.lista.remove(pCarta);
	}
	
	public int contar()
	{
		return this.lista.size();
	}
	
	public void mostrarBaraja()
	{
		Iterator<Carta> itr = getIterador();
		int pos=1;
		while (itr.hasNext())
		{
			Carta carta =itr.next();
			System.out.println("Pos: "+pos+ "Carta: "+carta.toString());
			pos++;
		}
		
	}
	
	private Iterator<Carta> getIterador()
	{
		return this.lista.iterator();
	}


	public Carta obtenerCarta(int pos) 
	{
		Carta carta = this.lista.get(pos);
		return carta;
	}
	
}
