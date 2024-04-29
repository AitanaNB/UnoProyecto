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
		Mazo.getMazo().inicializarMazo();
		Mazo.getMazo().mezcalrCarta();
		System.out.println("Mezclando cartas...");
		
		System.out.println("");
		System.out.println("Introduce nombre del jugador uno y pulsa intro :) :");
		
		String nombre1;
		nombre1=Teclado.getTeclado().leerString();
		Teclado.getTeclado().leerString();
		jugador1.setNombre(nombre1);
		System.out.println("El nombre del jugador uno es: "+nombre1);
		
		System.out.println("");
		System.out.println("Introduce nombre del jugador dos y pulsa intro :) :");
		
		String nombre2;
		nombre2= Teclado.getTeclado().leerString();
		jugador2.setNombre(nombre2);
		System.out.println("El nombre del jugador dos es: "+nombre2);
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
