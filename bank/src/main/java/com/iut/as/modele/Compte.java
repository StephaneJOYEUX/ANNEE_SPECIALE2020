package com.iut.as.modele;

/***
 * Classe 'abstraite' ... donc on ne peut pas faire un 'new direct' :
 * 
 * @author stephane.joyeux
 *
 */
public abstract class Compte {

	private String numCompte;

	private Double solde;

	public Double getSolde() {
		return solde;
	}

	protected void setSolde(Double solde) {
		this.solde = solde;
	}

	public String getNumCompte() {
		return numCompte;
	}

	// Constructeur - super() -> lien vers la classe parent.
	protected Compte(String numCompte, Double solde) {
		this.numCompte = numCompte;
		this.solde = solde;
	}

	// Cette méthode est 'abstraite' :
	// La méthode 'débiter' est différente selon le type de compte.
	public abstract boolean debiter(Double montant);

	// Permet de savoir si un découvert est autorisé :
	public abstract boolean decouvertAutorise();

	// La méthode 'créditer' est commune à tous les comptes :
	public boolean crediter(Double montant) {
		if (montant != null) {
			solde += montant;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Compte N° " + numCompte + " à un solde de " + solde;
	}
}
