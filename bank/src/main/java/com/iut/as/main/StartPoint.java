package com.iut.as.main;

import java.util.List;

import com.iut.as.enumerations.EPersistance;
import com.iut.as.factory.DaoFactory;
import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Compte;

public class StartPoint {

	public static void main(String[] args) {
		try {
			// Connection à la base MySQL :
			DaoFactory daoF = DaoFactory.getDaoFactory(EPersistance.MYSQL);
			// Connection à la table 'compte' :
			IDaoCompte dao = daoF.getDaoCompte();
			List<Compte> comptes = dao.getComptes();
			for (Compte compte : comptes) {
				System.out.println(compte.toString());
			}

		} catch (Exception e) {
			System.out.println("Connection impossible " + e.getMessage());
		}

	}

}
