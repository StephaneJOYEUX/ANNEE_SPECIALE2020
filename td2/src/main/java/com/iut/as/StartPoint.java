package com.iut.as;

import com.iut.as.modele.Mathematic;

public class StartPoint {

	public static void main(String[] args) {
		System.out.println("Hello World TD2");
		Mathematic maths = new Mathematic();
		System.out.println("Le resultat de 2 + 4 est " + maths.addition(2, 4));
		try {
			System.out.println("Le resultat de 4 / 2 est " + maths.division(4, 2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
