package org.pmoo.proyecto;

import java.util.Scanner;

public class Teclado 
{
	private static Teclado miTeclado= new Teclado();
	private static Scanner sc = new Scanner(System.in);
	
	private Teclado()
	{	}
	public static Teclado getTeclado()
	{
		return miTeclado;
	}
	
	public static int leerEntero(String pMenPrevio) 
	{
		System.out.println(pMenPrevio);
		return sc.nextInt();
	}
	
	public static String leerString(String pMenPrevio)
	{
		System.out.println(pMenPrevio);
		return sc.nextLine();
	}
	

}
