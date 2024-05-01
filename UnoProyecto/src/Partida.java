package org.pmoo.proyecto;

public class Partida
{
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public static Partida miPartida = new Partida();
	
	private Partida ()
	{}
	
	public static Partida getPartida() throws NoEsOpcionException
	{
		return miPartida;
	}
	
	public void jugarPartida() throws NumberFormatException, NoEsOpcionException
	{
		Teclado miTeclado=Teclado.getTeclado();
		
		System.out.println("*********¡¡¡¡¡¡¡BIENVENIDO A LA PARTIDA!!!!!!!*********");
		
		//Inicializar mazo y mezclar las cartas		
		Mazo.getMazo().inicializarMazo();
		Mazo.getMazo().mezclarCarta();
		System.out.println("\nMezclando cartas...");
		
		
		//Asignar el nombre a los jugadores
		System.out.println("Introduce el nombre del jugador 1:");
       	String nombreJugador1 = miTeclado.leerString("Pulsa enter");
        jugador1 = new Jugador(nombreJugador1);// llamar a la constructora en vez de setter

        System.out.println("Introduce el nombre del jugador 2:");
        String nombreJugador2 = miTeclado.leerString("Pulsa enter");
        jugador2 = new Jugador(nombreJugador2);

        System.out.println("Los jugadores son: " + jugador1.getNombre() + " y " + jugador2.getNombre());
        
        //Repartir 7 cartas a cada uno
        System.out.println("\nRepartiendo 7 cartas a cada jugador...");
        this.repartirCartas(jugador1, 7);
        this.repartirCartas(jugador2, 7);
        
        System.out.println("Empieza " + nombreJugador1+"\n");
        System.out.println(" ");
        this.jugadorActual=jugador1;
        
        //Mostrar la primera carta
        Carta primeraC= Mazo.getMazo().quitarCartaDelMazo();
        PilaDescarte.getPilaDescarte().anadirCarta(primeraC);
        while (primeraC instanceof CartaEsp)
        {
        	primeraC= Mazo.getMazo().quitarCartaDelMazo();
        	PilaDescarte.getPilaDescarte().anadirCarta(primeraC);
        }
        System.out.println("Se empieza con la carta: "+primeraC.toString());
        
        int posCarta; //Posicion de la carta que decide jugar
        
        //Bucle principal del juego
		while (!finalizarPartida())
		{	
			System.out.println(jugadorActual.getNombre() + ", estas son tus cartas:");
		    System.out.println(".......................................................................");
		    System.out.println();
		    jugadorActual.verCartas();

		    System.out.println(".......................................................................");
		    System.out.println("Pulsa R para robar, o J para jugar. ");

		    String opcion = miTeclado.leerString("Pulsa enter");

		    if (opcion.equals("J") || opcion.equals("j")) 
		    { // Decide jugar
		        System.out.println("Teclea el valor de la posición de la carta que quieras jugar.");
		        System.out.println("");
		        
		        String input = miTeclado.leerString("Recuerda darle a enter :3 ");
		        		
		        
		        //excepcion si el usuario no introduce un numero por teclado
		        boolean todoBajoControl = false;
		        do {
		        	try {	
		        			posCarta = Integer.parseInt(input);
		        	 		//jugadorActual.usarCarta(posCarta - 1);
		        			todoBajoControl= true;
		        		}
		        	catch (NumberFormatException nfe)
		        	{
		        		input="0";	
		        		System.out.println("Ha ocurrido NumberFormatException");
		        		System.out.println("Posición introducida inválida");
		        			
		        	}
		        } while (!todoBajoControl);
		        
		        posCarta = Integer.parseInt(input);
		        jugadorActual.usarCarta(posCarta-1);
		        
		    } 
		    else if (opcion.equals("R") || opcion.equals("r")) 
		    { // Decide robar
		        jugadorActual.robarCarta();
		        System.out.println("");
		    } 
		    else 
		    {
			System.out.println("No has introducido una de las opciones");
		       System.out.println("\nGAME OVER");
		       throw (new NoEsOpcionException());
		    }
		    
		    
		    System.out.println("");
	        if (PilaDescarte.getPilaDescarte().obtenerUltimaCarta() instanceof CartaEsp && jugadorActual.haJugado())
		    {
		    	if(jugadorActual==jugador1)
		    	{
		    		repartirCartas(jugador2, 2);
		    	}
		    	else
		    	{
		    		repartirCartas(jugador1, 2);
		    	}
		    	
		    }
		    
		    jugadorActual.gritarUno();
		    if (!jugadorActual.haGanado())
		    {
		    	turnoJugador(); // Cambia de jugador
		    }
		    System.out.println("\n.......................................................................");
		    System.out.println("\nÚltima carta jugada: "+ PilaDescarte.getPilaDescarte().obtenerUltimaCarta());
		}
		System.out.println("¡¡¡¡¡¡ENHORABUENA "+ jugadorActual.getNombre() + "HAS GANADO!!!!!!!");
	}

	
	public void repartirCartas(Jugador pJugador, int pCuantas)
	{
		int i=0;
		do{
			pJugador.agregarCartaAMano(Mazo.getMazo().quitarCartaDelMazo());
			i++;
			
		} while (i<pCuantas);
	}
	
	private boolean finalizarPartida()
	{
		boolean finalizado =false;
		if (jugador1.haGanado() || jugador2.haGanado())
		{
			finalizado= true;
		}
		return finalizado;
		
	}
	
	public void turnoJugador()
	{
	if (jugadorActual.turnoTerminado())
		{
			if (jugadorActual==jugador1)
			{
				jugadorActual=jugador2;
			}
			else 
			{
				jugadorActual=jugador1;	
			}
		}	
	}


}

