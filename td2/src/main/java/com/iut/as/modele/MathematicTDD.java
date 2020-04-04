package com.iut.as.modele;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

public class MathematicTDD implements IMaths {

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int soustraction(int a, int b) {
		return a - b;
	}

	@Override
	public double division(Integer a, Integer b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			System.out.println("Division par zero non autorisée");
			throw new MathematicException(e.getMessage());
		}
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
