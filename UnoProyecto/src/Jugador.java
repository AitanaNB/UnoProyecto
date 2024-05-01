package org.pmoo.proyecto;

public class Jugador 
{
	private String nombre;
	private Baraja baraja;
	private boolean haJugado=false;
	
	public Jugador (String pNombre)
	{
		this.nombre=pNombre;
		this.baraja=new Baraja();
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void verCartas()
	{
		this.baraja.mostrarBaraja();
	}
	
	public void robarCarta ()
	{
		Carta cartaRobada = Mazo.getMazo().quitarCartaDelMazo();
	    System.out.println("\nHas robado esta carta: "+cartaRobada.toString());
	    if (cartaRobada.puedeUsarse())
	    {
	    	PilaDescarte.getPilaDescarte().anadirCarta(cartaRobada);
	    	System.out.println(nombre + " ha robado una carta y la ha jugado.");
	    	this.haJugado=true;
	    }
	    else
	    {
	    	agregarCartaAMano(cartaRobada);
	    	cartaRobada = Mazo.getMazo().quitarCartaDelMazo();
	    	agregarCartaAMano(cartaRobada);
	    	System.out.println("La primera carta robada no se puede usar. Debes robar otra.");
	    	System.out.println("\nHas robado esta carta: "+cartaRobada.toString());
	    }
	    
	}
	
	public void gritarUno()
	{
		if (baraja.contar()==1)
		{
			System.out.println("\n"+this.nombre+" grita:   ¡¡¡UNO!!!");
		}
	}
	
	public void usarCarta(int pos)
	{
	    if (pos >= 0 && pos < baraja.contar()) 
	    {
	        Carta carta = baraja.obtenerCarta(pos); //obtiene la carta en la posición pos
	        if (carta.puedeUsarse()) 
	        {
	            // La carta puede usarse, la removemos de la baraja del jugador y la agregamos a la pila de descarte
	            this.baraja.quitar(carta);
	            PilaDescarte.getPilaDescarte().anadirCarta(carta);
	            System.out.println(nombre + " ha jugado una carta.");
	            this.haJugado=true;
	        }
	        else 
	        {
	            System.out.println("No puedes jugar esa carta en este momento.");
	            // El jugador no puede jugar la carta
	            this.robarCarta();
	        }
	    } 
	    else 
	    {
	    	System.out.println("Posición de carta inválida.");
	    }
	}
	
	public void agregarCartaAMano(Carta pCarta)
	{
		this.baraja.anadir(pCarta);
	}
	
	public boolean turnoTerminado()
	{
		return true;
	}
	
	
	public boolean haGanado()
	{
		return this.baraja.contar()==0;
	}
	
	public boolean haJugado()
	{
		return haJugado;
	}
}
