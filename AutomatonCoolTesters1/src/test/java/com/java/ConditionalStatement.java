package com.java;

import org.apache.poi.util.SystemOutLogger;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int velocidad = 80; // km/hr
		int limitevelocidad = 80;
		
		if (velocidad > limitevelocidad) {
			System.out.println("El usuario excede la velocidad");
		} else {System.out.println("El usuario tiene velocidad adecuada");
		}
		
		// if anidado IF ELSE IF
		
		boolean carretera = false;
		if(carretera) {
			System.err.println("Carretera");
			limitevelocidad =110;
			if(velocidad > limitevelocidad) {
			System.out.println("El coche va a exceso de velocidad");
		}else { System.out.println("El coche va a velocidad adecuado");
		}
		}else if (velocidad > limitevelocidad) {
			System.out.println("calle");
			System.out.println("El coche va a exceso de velocidad, multa!");
		}else {System.out.println("El coche va a velocidad adecuada");		
		
	}
		
		
		// switch case
		
		int temperature = 12;
		switch (temperature) {
		case 5:
			System.out.println("Clima muy frio");
		break;
		case 12: 
			System.out.println("Clima templado");
		break;
		}
		
}}
