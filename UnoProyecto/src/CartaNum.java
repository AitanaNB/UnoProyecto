package org.pmoo.proyecto;

public class CartaNum extends Carta 
{
	private int numero;
	
	public CartaNum(String pColor, int pNum)
	{
		super(pColor);
		this.numero=pNum;
	}
	
	@Override
	public boolean puedeUsarse()
	{
		boolean sePuede=false;
		if (this.getNumero()==PilaDescarte.getPilaDescarte().obtenerUltimaCarta().getNumero() || (this.getColor().equals(PilaDescarte.getPilaDescarte().obtenerUltimaCarta().getColor())))
		{
			sePuede=true;
		}
		return sePuede;
	}
	
	@Override
	public int getNumero()
	{
		return this.numero;
	}


}
