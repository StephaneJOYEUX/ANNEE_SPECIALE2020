package com.iut.as.modele;

import com.iut.as.interfaces.ICarre;

public class Carre implements ICarre {

	@Override
	public void dessine() {
		System.out.println("Je suis un carré");

	}

	@Override
	public int getCote() {
		return 7;
	}

	@Override
	public int getPosX() {
		return 3;
	}

	@Override
	public int getPosY() {
		return 0;
	}

}
