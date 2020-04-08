package com.iut.as.adapteur;

import com.iut.as.interfaces.ICarre;
import com.iut.as.interfaces.IRond;

public class CarreRondAdapter implements IRond {

	private ICarre carre;

	public CarreRondAdapter(ICarre carre) {
		// en clair mon constructeur encapsule un carré !
		this.carre = carre;
		System.out.println("J'ai un carré mais je vais le transformer en rond !");
	}

	@Override
	public void dessine() {
		this.carre.dessine();
		System.out.println("Mais je deviens un rond ");
	}

	@Override
	public int positionXCentre() {
		return carre.getPosX();
	}

	@Override
	public int positionYCentre() {
		return carre.getPosY();
	}

	@Override
	public int getRayon() {
		return carre.getCote();
	}
}
