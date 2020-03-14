package com.iut.as.modele;

public class A {

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static void testStatic() {
		System.out.println("Je suis dans la méthode statique");
	}

	@Override
	public String toString() {
		return "la valeur de i est " + i;
	}
}
