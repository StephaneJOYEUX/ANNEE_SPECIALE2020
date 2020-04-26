package com.iut.as.modele;

public  class CompteSansDecouvert extends Compte{

	public CompteSansDecouvert() {
		super();
		
	}

	public CompteSansDecouvert(double solde, String numCompte, double montant, CompteAvecDecouvert compDecouvert,
			CompteSansDecouvert compSansDecouvert) {
		super(solde, numCompte, montant, compDecouvert, compSansDecouvert);
	}
	
	public void debiter(double montant) {
		
		if(montant> this.solde) {
			
			System.out.println("impossible car ya pas assez d'argent");
		}else {
		    System.out.println(this.solde-=montant);
		}
		
	}
	
	

}
