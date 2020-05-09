package com.iut.as.modele;

public class CompteAvecDecouvert extends Compte {

	private Double decouvertAutorise;

	public Double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(Double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public CompteAvecDecouvert(String numCompte, Double solde, Double decouvertAutorise) {
		super(numCompte, solde);
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public boolean debiter(Double montant) {
		if (montant != null) {
			if (this.getSolde() - montant >= -decouvertAutorise) {
				setSolde(this.getSolde() - montant);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean decouvertAutorise() {
		return true;
	}
}
