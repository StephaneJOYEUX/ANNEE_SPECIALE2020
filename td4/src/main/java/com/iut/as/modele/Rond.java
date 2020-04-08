package com.iut.as.modele;

import com.iut.as.interfaces.IRond;

public class Rond implements IRond {

	@Override
	public void dessine() {
		System.out.println("Je suis un rond");
	}

	@Override
	public int positionXCentre() {
		return 4;
	}

	@Override
	public int positionYCentre() {
		return 3;
	}

	@Override
	public int getRayon() {
		return 5;
	}

}
