package com.iut.as.modele;

public class Compte  {
	public CompteAvecDecouvert compDecouvert; 
	public CompteSansDecouvert compSansDecouvert; 
	
	
	//remaque revoir sur le type des variables; 
	
	public double solde; 
	public String numCompte; 
	public double montant; 

	public Compte() {
		
	}

	
	/*public Compte( double solde,String numCompte, double montant) {
		super();
		this.solde=solde; 
		this.numCompte=numCompte; 
		this.montant=montant;
	}*/
	
	
	public Compte( double solde,String numCompte, double montant, CompteAvecDecouvert compDecouvert,CompteSansDecouvert compSansDecouvert) {
		super();
		this.solde=solde; 
		this.numCompte=numCompte; 
		this.montant=montant; 
		
		this.compDecouvert=compDecouvert; 
		this.compSansDecouvert=compSansDecouvert; 
	}

	public double getSolde() {
		return solde;
	}


    public void setSolde(double solde) {
		this.solde = solde;
	}


	public String getNumCompte() {
		return numCompte;
	}


	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	
	public void crediter(double montant) {
		solde+= montant; 
		
	}
	
	
	public void debiter(double montant) {
		
		if(montant> this.solde) {
			
			System.out.println("impossible car ya pas assez d'argent");
		}else {
			//this.solde-=montant; 
		    System.out.println(this.solde-=montant);
		}
		
	}
	

	
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", numCompte=" + numCompte + ", montant=" + montant + ", getSolde()="
				+ getSolde() + ", getNumCompte()=" + getNumCompte() + ", getMontant()=" + getMontant() + 
				 "]";
	}
	
	
	
	

}
