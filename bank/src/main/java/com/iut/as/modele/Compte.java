package com.iut.as.modele;

import org.hibernate.cfg.NotYetImplementedException;

/***
 * Classe 'abstraite' ... donc on ne peut pas faire un 'new direct' :
 * 
 * @author stephane.joyeux
 *
 */
public abstract class Compte {

	private String numCompte;

	private Double solde;

	protected Double getSolde() {
		return solde;
	}

	protected void setSolde(Double solde) {
		this.solde = solde;
	}

	protected String getNumCompte() {
		return numCompte;
	}

	// Constructeur - super() -> lien vers la classe parent.
	public Compte(String numCompte, Double solde) {
		this.numCompte = numCompte;
		this.solde = solde;
	}

	// Cette méthode est 'abstraite' :
	// La méthode 'débiter' est différente selon le type de compte.
	public abstract boolean debiter(Double montant);

	// La méthode 'créditer' est commune à tous les comptes :
	public boolean crediter(Double montant) {
		throw new NotYetImplementedException();
	}
}
