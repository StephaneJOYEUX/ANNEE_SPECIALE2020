package com.iut.as.modele;

public class CompteSansDecouvert extends Compte {

	public CompteSansDecouvert(String numCompte, Double solde) {
		super(numCompte, solde);
	}

	@Override
	public boolean debiter(Double montant) {
		if (montant != null) {
			if (this.getSolde() - montant >= 0) {
				this.setSolde(this.getSolde() - montant);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean decouvertAutorise() {
		return false;
	}
}
