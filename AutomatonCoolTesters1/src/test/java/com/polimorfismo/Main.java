package com.polimorfismo;

public class Main {

	public static void main(String[] args) {

		Animal Humano = new Humano();
		Humano.speak();
		
		Animal Gato = new Gato();
		Gato.speak();

		Animal Animal = new Humano ();
		Animal.speak();
		
		Animal = new Gato();
		Animal.speak();
		
		Animal= new Gallo();
		Animal.speak();
		
		Animal= new Perro();
		Animal.speak();
	}

}
