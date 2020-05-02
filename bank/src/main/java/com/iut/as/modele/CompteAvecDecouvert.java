package com.iut.as.modele;

import org.hibernate.cfg.NotYetImplementedException;

public class CompteAvecDecouvert extends Compte {

	private Double decouvertAutorise;

	public CompteAvecDecouvert(String numCompte, Double solde) {
		super(numCompte, solde);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean debiter(Double montant) {		
		throw new NotYetImplementedException();
	}
}
