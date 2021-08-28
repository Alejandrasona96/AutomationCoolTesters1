package com.java;

import org.apache.poi.util.SystemOutLogger;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte abc = 125;
		short var = 30000;
		
		double altura = 2.54;
		System.out.println(altura); //para imprimir double
		
		char letra = '\u00D4';
		System.out.println(letra); 
		
		String frase = "Hola ";
		String frase2 = "Mundo "; // string se declara con la primera en mayuscula
		int frase3 = 4;
		System.out.println(frase+frase2+frase3);
		
		int x = 3;
		int y = 4;
		int suma= x*y;
		System.out.println(suma);//operadores aritmético
		
		int a = 3;
		a++;
		System.out.println(a); // unario, para incrementar o decrementar un valor en uno 
		
		
		int var1 = 3;
		int var2 = 4;
		if (var1!= var2)
		{System.out.println("Here");
		}
	}

}
