package com.iut.as.modele;

import com.iut.as.interfaces.IMaths;

public class Mathematic implements IMaths {

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public double division(int a, int b) {
		return a / b;
	}

	@Override
	public int multiplication(int a, int b) {
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
			ret += b;
		}
		if (signePositif) {
			return ret;
		}
		return -ret;
	}

	@Override
	public int soustraction(int a, int b) {
		return a - b;
	}
}
