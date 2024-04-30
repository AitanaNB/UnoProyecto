package org.pmoo.proyecto;

public class Jugador 
{
	private String nombre;
	private Baraja baraja;
	
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
	    agregarCartaAMano(cartaRobada);
	    System.out.println("Has robado esta carta ");
	    System.out.println(cartaRobada.toString());
	}
	
	public void gritarUno()
	{
		if (baraja.contar()==1)
		{
			System.out.println("¡¡¡UNO!!!");
		}
	}
	
	public void usarCarta(int pos)
	{
	    if (pos >= 0 && pos < baraja.contar()) {
	        Carta carta = baraja.obtenerCarta(pos); //obtiene la carta en la posición pos
	        if (carta.puedeUsarse()) 
	        {
	            // La carta puede usarse, la removemos de la baraja del jugador y la agregamos a la pila de descarte
	            baraja.quitar(carta);
	            PilaDescarte.getPilaDescarte().anadirCarta(carta);
	            System.out.println(nombre + " ha jugado una carta.");
	        } 
	        else 
	        {
	            System.out.println("No puedes jugar esa carta en este momento.");
	            // El jugador no puede jugar la carta, roba una del mazo
	            Carta cartaRobada = Mazo.getMazo().quitarCartaDelMazo();
	            if (cartaRobada.puedeUsarse()) {
	                // Si la carta robada se puede usar, el jugador la juega inmediatamente
	                PilaDescarte.getPilaDescarte().anadirCarta(cartaRobada);
	                System.out.println(nombre + " ha robado una carta y la ha jugado.");
	            } 
	            else 
	            {
	                // Si la carta robada tampoco se puede usar, el jugador roba otra carta y finaliza su turno
	                cartaRobada = Mazo.getMazo().quitarCartaDelMazo();
	                System.out.println(nombre + " ha robado una carta pero no puede jugarla.");
	            }
	        }
	    } 
	    else 
	    {
	        System.out.println("Posición de carta inválida.");
	    }
	}
	
	public void agregarCartaAMano(Carta pCarta)
	{
		baraja.anadir(pCarta);
	}
	
	public boolean turnoTerminado()
	{
		return true;
	}

	public boolean haGanado()
	{
		return this.baraja.contar()==0;
	}
}
