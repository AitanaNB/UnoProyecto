package org.pmoo.proyecto;

public class Partida 
{
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public static Partida miPartida = new Partida();
	
	private Partida ()//Jugador pJugador1, Jugador pJugador2, Jugador pActual)
	{
		//this.jugador1=pJugador1;
		//this.jugador2=pJugador2;
		//this.jugadorActual=pJugador1;
	}
	
	public static Partida getPartida()
	{
		return miPartida;
	}
	
	public void jugarPartida()
	{
		Teclado miTeclado=Teclado.getTeclado();
		//inicializar mazo y mezclar las cartas		
		Mazo.getMazo().inicializarMazo();
		Mazo.getMazo().mezclarCarta();
		System.out.println("Mezclando cartas...");
		
		System.out.println("");
		System.out.println("Bienvenido a la partida!");
		//asignar el nombre a los jugadores
		System.out.println("Introduce el nombre del jugador 1:");
       	String nombreJugador1 = miTeclado.leerString("Pulsa enter");
        jugador1 = new Jugador(nombreJugador1);//, null); // llamar a la constructora en vez de setter

        System.out.println("Introduce el nombre del jugador 2:");
        String nombreJugador2 = miTeclado.leerString("Pulsa enter");
        jugador2 = new Jugador(nombreJugador2);//, null);

        System.out.println("Los jugadores son: " + jugador1.getNombre() + " y " + jugador2.getNombre());
        
        //repartir 7 cartas a cada uno
        System.out.println("");
        System.out.println("Repartiendo 7 cartas a cada jugador...");
        
        this.repartirCartas(jugador1);
        this.repartirCartas(jugador2);
        
        System.out.println("Empieza " + nombreJugador1);
        System.out.println(" ");
        this.jugadorActual=jugador1;
        
        System.out.println("Se empieza con la carta: ");
        Carta primeraC= Mazo.getMazo().quitarCartaDelMazo();
        PilaDescarte.getPilaDescarte().anadirCarta(primeraC);
        System.out.println(primeraC.toString());
        
        int valorJugada =0; //sirve para definir con mayor facilidad cuando acaba la partida
        int posCarta; //posicion de la carta que decide jugar
        
	while (!finalizarPartida())
        {
        	
		if (jugadorActual==jugador1) //turno del jugador1
		{		
			System.out.println(nombreJugador1 + ", estas son tus cartas:");
			System.out.println("..........................................");
			System.out.println();
			this.jugador1.verCartas();
        
			System.out.println("..........................................");
			System.out.println("Pulsa R para robar, o J para jugar. ");
        
			String opcion = Teclado.leerString("Pulsa enter");
			
			if (opcion.equals("J") || opcion.equals("j")) //decide jugar
			{
				System.out.println("Teclea el valor de la posición de la carta que quieras jugar.");
				System.out.println("Si escoges una carta que no puedes jugar, robas :) ");
				posCarta=miTeclado.leerString("Recuerda darle a enter :3 ");
				jugador1.usarCarta(Integer.parseInt(posCarta)-1);
				this.turnoJugador();
				
				
			}
			else if (opcion.equals("R") || opcion.equals("r")) //decide robar
			{
				jugador1.robarCarta();
				System.out.println("");
							
			}
			else 
			{
				System.out.println("R o J por favor ");
				
			}
			
			jugador1.haGanado();
			this.jugadorActual=jugador2;
			       
		}
		if (jugadorActual==jugador2)
		{
			
			System.out.println(nombreJugador2 + ", estas son tus cartas:");
			System.out.println("..........................................");
			System.out.println();
			this.jugador2.verCartas();
        
			System.out.println("..........................................");
			System.out.println("Pulsa R para robar, o J para jugar. ");
        
			String opcion = miTeclado.leerString("Pulsa enter");
			
			if (opcion.equals("J") || opcion.equals("j")) //decide jugar
			{
				System.out.println("Teclea el valor de la posición de la carta que quieras jugar.");
				System.out.println("Si escoges una carta que no puedes jugar, robas :) ");
				posCarta=miTeclado.leerString("Recuerda darle a enter :3 ");
				jugador2.usarCarta(Integer.parseInt(posCarta)-1);
				this.turnoJugador();
				
				
			}
			else if (opcion.equals("R") || opcion.equals("r")) //decide robar
			{
				jugador2.robarCarta();
				System.out.println("");			
				
			}
			else 
			{
				System.out.println("R o J por favor ");
			}
			jugador2.haGanado();
			turnoJugador();
		}
		
        }
        System.out.println("¡¡¡¡¡¡ENHORABUENA "+ jugadorActual.getNombre() + "HAS GANADO!!!!!!!");	
	
	}
	
	public void repartirCartas(Jugador pJugador)
	{
		int i=0;
		do{
			pJugador.agregarCartaAMano(Mazo.getMazo().quitarCartaDelMazo());
			i++;
			
		} while (i<7);
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
	if (jugadorActual.turnoTerminado()) //no hace falta xq se cambia directamente
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
