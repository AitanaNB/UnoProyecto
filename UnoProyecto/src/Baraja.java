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
}
