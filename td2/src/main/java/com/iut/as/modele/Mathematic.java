package com.iut.as.modele;

public class Mathematic {

	public int addition(int a, int b) {
		return a + b;
	}

	public double division(int a, int b) {
		return a / b;
	}

	public int multiplication(int a, int b) {
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
}



