package com.iut.as.factory.modele;

import static com.iut.as.enumerations.ETypeCompte.AVEC_DECOUVERT;
import static com.iut.as.enumerations.ETypeCompte.SANS_DECOUVERT;

import com.iut.as.enumerations.ETypeCompte;
import com.iut.as.modele.Compte;
import com.iut.as.modele.CompteAvecDecouvert;
import com.iut.as.modele.CompteSansDecouvert;

public class CompteFactory {

	/* @return - Un compte en fonction de son type (avec ou sans découvert). */
	public static Compte getCompte(ETypeCompte type, String numCompte, Double solde, Double decouvertAutorise) {
		if (AVEC_DECOUVERT.equals(type)) {
			return new CompteAvecDecouvert(numCompte, solde, decouvertAutorise);
		} else {
			return new CompteSansDecouvert(numCompte, solde);
		}
	}

	/* @return - Un compte sans découvert autorisé. */
	public static Compte getCompte(ETypeCompte type, String numCompte, Double solde) {
		if (SANS_DECOUVERT.equals(type)) {
			return new CompteSansDecouvert(numCompte, solde);
		}
		return null;
	}
}
