package org.pmoo.proyecto;

public class CartaNum extends Carta 
{
	private int numero;
	
	public CartaNum(String pColor, int pNum)
	{
		super(pColor);
		this.numero=pNum;
	}
	
	public void jugarCarta()
	{
		System.out.println("La carta jugada es de color "+getColor()+" y numero "+this.numero);
	}
	
	@Override
	public boolean puedeUsarse()
	{
		boolean sePuede=false;
		if (this.getNumero()==PilaDescarte.getPilaDescarte().obtenerUltimaCarta().getNumero())
		{
			sePuede=true;
		}
		return sePuede;
	}
	
	public int getNumero()
	{
		return this.numero;
	}


}
