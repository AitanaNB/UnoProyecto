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
		System.out.println("La carta jugada es de color "+getColor()+" y numero"+this.numero);
	}
	
	public boolean puedeUsarse()
	{
		//Implementación...
		boolean sePuede = true;
		return sePuede;
	}

}
