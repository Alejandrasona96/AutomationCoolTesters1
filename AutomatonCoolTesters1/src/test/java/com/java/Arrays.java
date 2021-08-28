package com.java;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String []dias = {"L", "M", "Mi", "J", "V", "S", "D"};  // se empieza a contar desde 0
		System.out.println("El dia de hoy es "+ dias [4]);
		
		for (int i = 0; i< dias.length; i++ ) {
			System.out.println(dias[i]);
		}
		
	//Arreglo bidimensional
		
		String [][] nombrecompleto = new String [2][3];
		
		nombrecompleto [0][0] = "Ricardo";
		nombrecompleto [0][1] = "Karen";
		nombrecompleto [0][2] = "Sonia";
		nombrecompleto [1][0] = "Avalos";
		nombrecompleto [1][1] = "Ramirez";
		nombrecompleto [1][2] = "Cardenas";
System.out.println("El nombre es "+ nombrecompleto[0][0]+ " "+nombrecompleto[1][0]);
		
	}

}
