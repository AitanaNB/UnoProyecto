package org.pmoo.proyecto;

import java.util.ArrayList;

public class Baraja 
{
	private ArrayList<Carta> lista;
	
	public Baraja()
	{
		this.lista=new ArrayList<Carta>();
	}
	
	public void añadir(Carta pCarta)
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
		while (itr.hasNext())
		{
			int pos = 1;
			Carta carta =itr.next();
			System.out.println("Pos:"+pos+"Color: "+carta.getColor());
			if (carta instanceof CartaEsp)
			{
				System.out.println("Carta toma 2");
			}
			else if (carta instanceof CartaNum)
			{
				System.out.println("Numero: "+((CartaNum)carta).getNumero());
			}
		}
		
	}
	
	private Iterator<Carta> getIterador()
	{
		return this.lista.iterator();
	}

	public void quitarCarta()
	{
		
	}
}
