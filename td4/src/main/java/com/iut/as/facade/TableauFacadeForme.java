package com.iut.as.facade;

import com.iut.as.interfaces.ICarre;
import com.iut.as.interfaces.IRond;
import com.iut.as.modele.Carre;
import com.iut.as.modele.Rond;

public class TableauFacadeForme {

	private IRond rond;

	private ICarre carre;

	public TableauFacadeForme() {
		rond = new Rond();
		carre = new Carre();
	}

	/* Cette méthode cache la complexité de création du tableau */
	public void dessine() {
		rond.dessine();
		carre.dessine();
		// autre chose ..
	}

}
