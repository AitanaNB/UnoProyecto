package org.pmoo.proyecto;

public abstract class Carta 
{
	private String color;
	
	public Carta (String pColor)
	{
		this.color=pColor;
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

	
	@Override
	public String toString() 
	{
	    if (this instanceof CartaNum) 
	    {
	        return " Carta numérica de color " + color + " y número " + ((CartaNum)this).getNumero();
	    } 
	    else if (this instanceof CartaEsp) 
	    {
	        return " Carta toma 2 de color " + color;
	    } else 
	    {
	        return "Carta desconocida";
	    }
	}

}

