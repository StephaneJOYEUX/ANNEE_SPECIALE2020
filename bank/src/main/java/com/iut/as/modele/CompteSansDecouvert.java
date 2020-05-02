package com.iut.as.modele;

import org.hibernate.cfg.NotYetImplementedException;

public class CompteSansDecouvert extends Compte {

	public CompteSansDecouvert(String numCompte, Double solde) {
		super(numCompte, solde);
	}

	@Override
	public boolean debiter(Double montant) {
		throw new NotYetImplementedException();
	}

}
