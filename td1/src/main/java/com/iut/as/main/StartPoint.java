package com.iut.as.main;

import com.iut.as.modele.A;

public class StartPoint {

	public static void main(String[] args) {
		System.out.println("Hello World");

		A a = new A();
		a.setI(3);
		System.out.println(a.toString());

		A.testStatic();
	}

}
