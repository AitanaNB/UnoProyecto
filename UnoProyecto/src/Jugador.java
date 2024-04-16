package org.pmoo.proyecto;

public class Jugador 
{
	private String nombre;
	private Baraja baraja;
	
	public Jugador (String pNombre, Baraja pBaraja)
	{
		this.nombre=pNombre;
		this.baraja=new Baraja();
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void robarCarta ()
	{
		
	}
	
	public void gritarUno()
	{
		if (baraja.contar()==1)
		{
			System.out.println("¡¡¡UNO!!!");
		}
	}
	
	public void usarCarta(int pPos)
	{
		
	}
	
	public void agregarCartaAMano(Carta pCarta)
	{
		baraja.anadir(pCarta);
	}
	
	public boolean turnoTerminado()
	{
		return true;
	}
}
