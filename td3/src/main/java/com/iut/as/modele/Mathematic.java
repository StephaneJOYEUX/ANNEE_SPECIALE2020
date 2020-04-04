package com.iut.as.modele;

import java.math.BigDecimal;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

/***
 * @description : Classe "Mathematic"
 * 
 * @author stephane.joyeux
 *
 */
public class Mathematic implements IMaths {

	private Integer a;
	private Integer b;

	public Mathematic() {
		// Constructeur standard !!
	}

	public Mathematic(String a, String b) {
		try {
			this.a = new Integer(a);
			this.b = new Integer(b);
		} catch (NumberFormatException e) {
			throw new MathematicException("Opérateurs non numériques !");
		}
	}

	@Override
	public Integer addition() {
		return addition(a, b);
	}

	@Override
	public Integer addition(Integer a, Integer b) {
		if (checkOperators(a, b)) {
			return a + b;
		}
		throw new MathematicException("Addition impossible !");
	}

	@Override
	public Double division(Integer a, Integer b) {
		if (checkOperators(a, b)) {
			try {
				// Deprecated depuis jdk 11 ...
				// return new Double(a / b);
				/*
				 * je viens de casser quelque chose :) valider la non régresssion car je viens
				 * de faire une régression ça compile ça à l'air de bien fonctionner .. mais
				 * dans les faits .. je viens de créer un BUG et donc une régression... et si je
				 * n'avais pas les tests unitaires je ne pourrai pas le savoir aussi facilement
				 * !!!
				 */
				// Ce code est faux !! mauvais !!
				//return (Double) (a.doubleValue() / b.doubleValue());
				return calculDivision(a, b);

			} catch (ArithmeticException e) {
				// J'attrappe l'erreur et je préviens l'utilisateur (par exemple) :
				// Je renvoie mon exception --> Ou je l'encapsule dans une autre exception !
				throw new MathematicException(e, "Division par zero - exception");
			}
		}
		throw new MathematicException("division impossible !");
	}

	private Double calculDivision(Integer a, Integer b) {
		BigDecimal bg1 = new BigDecimal(a);
		BigDecimal bg2 = new BigDecimal(b);
		return bg1.divide(bg2).doubleValue();
	}

	@Override
	public Integer multiplication(Integer a, Integer b) {
		if (checkOperators(a, b)) {
			// Utilisation standard :
			// return a * b;
			// Utilisation de la méthode addition :
			int ret = 0;
			boolean signePositif = true;
			if (a < 0) {
				a = -a;
				signePositif = false;
			}
			for (int i = 0; i < a; i++) {
				// ret += b;
				ret = addition(ret, b);
			}
			if (signePositif) {
				return ret;
			}
			return -ret;
		}
		throw new MathematicException("multiplication impossible !");
	}

	@Override
	public Integer soustraction(Integer a, Integer b) {
		if (checkOperators(a, b)) {
			return a - b;
		}
		throw new MathematicException("soustraction impossible !");
	}

	/* @return 'vrai' si les deux variables a et b sont non nulles */
	private boolean checkOperators(Integer a, Integer b) {
		if (a != null && b != null) {
			return true;
		}
		if (a == null && b == null) {
			throw new MathematicException("Les deux opérateurs sont nuls!");
		}
		if (a == null) {
			throw new MathematicException("L'opérateur 'a' est null !");
		}
		if (b == null) {
			throw new MathematicException("L'opérateur 'b' est null !");
		}
		// En principe pas nécessaire :
		return false;
	}
}
