package com.iut.as.main;

import static com.iut.as.enumerations.EPersistance.Memoire;

import com.iut.as.dao.factory.DaoFactory;
import com.iut.as.interfaces.IDaoEtudiant;

public class StartPoint {

	public static void main(String[] args) {
		System.out.println("Test de la factory");
		// Ici la 'factory' a pour rôle de construire une DAO qui correspond à une
		// persistance en mémoire.
		DaoFactory daoF = DaoFactory.getDaoFactory(Memoire);

		// Recoit une dao de type Etudiant ...Toujours la même instance car on utilise
		// un singleton.
		IDaoEtudiant dao = daoF.getDaoEtudiant();
		IDaoEtudiant dao2 = daoF.getDaoEtudiant();
		System.out.println("dao == dao2 : " + (dao == dao2));

		// Lire un étudiant
		System.out.println(dao.read(1));

		System.out.println(dao.read(2));
	}
}
