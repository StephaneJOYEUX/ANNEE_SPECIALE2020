package com.iut.as.modele;

public class Bilan extends Observable {

	private int num;

	public int getNum() {
		return num;
	}

	public Bilan(int num) {
		System.out.println("Bilan N° " + num + " est créé.");
		this.num = num;
	}

	public void setChange() {

	}
}
