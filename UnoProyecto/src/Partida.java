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
		Mazo.getMazo().mezcalrCarta();
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
        
		if (jugadorActual==jugador1) 
		{		
			System.out.println(nombreJugador1 + ", estas son tus cartas:");
			System.out.println("..........................................");
			System.out.println();
			this.jugador1.getBaraja().mostrarBaraja();
        
			System.out.println("..........................................");
			System.out.println("Pulsa R para robar, o J para jugar. Recuerda darle a enter :3 ");
        
			String opcion= miTeclado.leerString("");
			
			if (opcion =="J" || opcion == "j") //decide jugar
			{
				System.out.println("Teclea el valor de la posición de la carta que quieras jugar (y dale al enter).");
				posCarta=miTeclado.leerEntero("");
				jugador1.usarCarta(posCarta);
				
			}
			if (opcion == "R" || opcion =="r") //decide robar
			{
				
			}
			else
			{
				System.out.println("Pulsa R o J, por favor. >:/ ");
			}
        
		}
		if (jugadorActual==jugador2)
		{
			 System.out.println(nombreJugador1 + ", estas son tus cartas:");
		     System.out.println("..........................................");
		     System.out.println();
		     this.jugador1.getBaraja().mostrarBaraja();
		        
		     System.out.println("..........................................");
		     System.out.println("Pulsa R para robar, o J para jugar. Recuerda darle a enter :3 ");
		}
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
		boolean finalizado=true;
		return finalizado;
	}
	
	public void turnoJugador()
	{
		
	}


}
