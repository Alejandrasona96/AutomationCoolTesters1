package com.java;

public class BucleStatement {

	public static void main(String[] args) { //el método inicia en el punto main
		// TODO Auto-generated method stub

		int numero= 1;
				
		while (numero <= 10) {
			System.out.println("El numero es:"+ numero );
			++numero; // es similar a la operación numero = +1
		}
		
		// Do-while
	int numerosum= 5;
	int sumtotal =0;
	int count =0;
	
	do {
		sumtotal += numerosum;// sumtotal= sumtotal + numerosum;
		++count;
	} while (sumtotal < 100);
		
	System.out.println("El numero se sumo " + count +" veces");
	
	int numfor = 10;
	
	for (int i=1; i<= numfor ; i++) {
	System.out.println("El numero for es " +i);
	 //para colocar un break en el for
	if (i==5) {
		break;
	}
	
	
	}

}
}
