package com.iut.as.factory.modele;

import com.iut.as.enumerations.ETypeCompte;
import com.iut.as.modele.Compte;
import com.iut.as.modele.CompteAvecDecouvert;
import com.iut.as.modele.CompteSansDecouvert;

public class CompteFactory {

	/* @return un compte en fonction de son type. */
	public static Compte getComptes(ETypeCompte type, String numCompte, Double solde, Double decouvertAutorise) {
		if (ETypeCompte.AVEC_DECOUVERT.equals(type)) {
			return new CompteAvecDecouvert(numCompte, solde, decouvertAutorise);
		} else {
			return new CompteSansDecouvert(numCompte, solde);
		}
	}
}
