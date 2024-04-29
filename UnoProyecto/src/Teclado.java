package org.pmoo.proyecto;

import java.util.Scanner;

public class Teclado 
{
	private static Teclado miTeclado= new Teclado();
	private static Scanner sc;
	
	private Teclado()
	{
		Teclado.sc=new Scanner(System.in);
	}
	public static Teclado getTeclado()
	{
		return miTeclado;
	}
	
	public int leerEntero() 
	{
		return sc.nextInt();
	}
	
	public String leerString()
	{
		return sc.nextLine();
	}
	

}
