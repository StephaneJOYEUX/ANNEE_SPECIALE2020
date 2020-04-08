package com.iut.as.main;

import com.iut.as.adapteur.CarreRondAdapter;
import com.iut.as.facade.TableauFacadeForme;
import com.iut.as.interfaces.ICarre;
import com.iut.as.interfaces.IRond;
import com.iut.as.modele.Carre;
import com.iut.as.modele.Rond;

public class StartPoint2 {

	public static void main(String[] args) {
		System.out.println("Patterd Adapter");
		// Sans le pattern facade :
		IRond rond = new Rond();
		rond.dessine();
		ICarre carre = new Carre();
		System.out.println("La longueur du côté est " + carre.getCote());
		carre.dessine();
		IRond newRond = new CarreRondAdapter(carre);
		newRond.dessine();
		System.out.println("Le rayon est " + newRond.getRayon());
		// avec le pattern facade
		System.out.println("PATTERN FACADE APPLIQUE");
		TableauFacadeForme facade = new TableauFacadeForme();
		facade.dessine();

	}

}
