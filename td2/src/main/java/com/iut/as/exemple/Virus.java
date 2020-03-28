package com.iut.as.exemple;

import com.iut.as.interfaces.IVirus;

public class Virus implements IVirus {

	@Override
	public void confinement() {
		System.out.println("ON RESTE CHEZ SOI !!");
	}

	@Override
	public void guerison() {
		System.out.println("Je suis plus malade");
	}

	@Override
	public void malade() {
		System.out.println("Je suis malade");
	}

	@Override
	public void contamination() {
		System.out.println("Je contamine tout le monde puisque personne ne respecte le confinement !");
	}

	@Override
	public void infirmier() {
		System.out.println("Je soigne les malades");
	}
}
