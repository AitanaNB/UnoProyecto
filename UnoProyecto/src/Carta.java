package org.pmoo.proyecto;

public abstract class Carta 
{
	private String color;
	
	public Carta (String pColor)
	{
		this.color=pColor;
	}
	
	public void jugarCarta()
	{
		System.out.println("La carta usada es de color"+this.color);
	}
	
	protected String getColor()
	{
		return this.color;
	}
	
	public boolean puedeUsarse()
	{
		/*Comprueba que el color de la carta actual coincide con
		el de la pila de descarte*/
		boolean sePuede=false;
		if (this.getColor()==PilaDescarte.getPilaDescarte().obtenerUltimaCarta().getColor())
		{
			sePuede=true;
		}
		return sePuede;
	}

	public int getNumero() 
	{
		return -1;
	}	

}

