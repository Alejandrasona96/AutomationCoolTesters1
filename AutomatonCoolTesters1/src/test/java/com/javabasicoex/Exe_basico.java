package com.javabasicoex;

public class Exe_basico {

	public static void main(String[] args) {
	
		
//Los gatos pasan la mayor parte del d�a jugando. En particular, juegan si la temperatura est� entre 25 y 35 (inclusive). A menos que sea verano, el l�mite superior es 45 (inclusive) en lugar de 35.
//Escriba un m�todo isCatPlaying que tenga 2 par�metros. El m�todo debe devolver verdadero si el gato est� jugando; de lo contrario, devolver falso
//El primer par�metro debe ser de tipo booleano y debe llamarse "verano" que representa si es verano.
//El segundo par�metro representa la temperatura y es de tipo int con el nombre "temperatura".
		
		
		
		boolean verano = false;
		int temp = 35;
		
		if (temp > 35 || temp <25 || verano) {
			System.out.println("El gato no puede salir a jugar");
		}else {System.out.println("El gato sale a jugar");
	}
	
	//imprimirVerificadorNumeros con 3 par�metros de tipo int
		
		int ent1= 1;
		int ent2= 2;
		int ent3= 3;
		
		if (ent1<0 || ent2<0 || ent3<0) {
			System.out.println("Valor no v�lido");}
		else if (ent1== ent2 && ent2==ent3 && ent3==ent1) {
				System.out.println("Todos los numero son iguales");}
		else if (ent1!=ent2 && ent2!=ent3 && ent3!=ent1) {
					System.out.println("Todos los n�meros son diferentes");}
					else {System.out.println("Ni todos son iguales ni diferentes");
		}

	//hasEqualSum con 3 parametros de tipo int.
		
		int ent4=2;
		int ent5=4;
		int ent6=7;
		boolean resultado;
		
		if (ent4+ent5==ent6) {
			System.out.println(resultado=true);} 
		else {System.out.println(resultado=false);}
		
}}
