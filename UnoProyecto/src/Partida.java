package org.pmoo.proyecto;

public class Partida 
{
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public static Partida miPartida = new Partida();
	
	public Partida (Jugador pJugador1, Jugador pJugador2, Jugador pActual)
	{
		this.jugador1=pJugador1;
		this.jugador2=pJugador2;
		this.jugadorActual=pJugador1;
	}
	
	private Partida()
	{}
	
	public void jugarPartida()
	{
		
	}
	
	public void repartirCartas(Jugador pJugador)
	{
		
	}
	
	private boolean finalizarPartida()
	{
		boolean finalizado=true;
		return finalizado;
	}
	
	public void turnoJugador()
	{
		
	}


}
