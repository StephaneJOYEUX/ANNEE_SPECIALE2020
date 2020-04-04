package com.iut.as.main;

import java.util.Scanner;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;
import com.iut.as.modele.Mathematic;
import com.iut.as.modele.UneAutreClassMathematic;

public class StartPoint {

	public static void main(String[] args) {
		// Exemple de console :
		System.out.println("Merci d'indiquer la valeur de a : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		System.out.println("Merci d'indiquer la valeur de b : ");
		String b = in.nextLine();
		try {
			IMaths maths = new Mathematic(a, b);
			System.out.println("Le resultat est : " + maths.addition());
		} catch (MathematicException e) {
			System.out.println("error");
		}

		IMaths maths1 = new Mathematic();
		IMaths maths2 = new UneAutreClassMathematic();
		// OK
		if (maths2 instanceof UneAutreClassMathematic) {
			((UneAutreClassMathematic) maths2).maMethodeAMoiUniquement();
		}
		if (maths1 instanceof UneAutreClassMathematic) {
			((UneAutreClassMathematic) maths1).maMethodeAMoiUniquement();
		}
	}

}
