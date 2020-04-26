package com.iut.as.modele;

public class CompteAvecDecouvert extends Compte {
	
	
	public static double montantAutorise =500;
	
	public CompteAvecDecouvert() {
		super();
	
	}
	
	@Override
	public void debiter(double montant) {
		
		if(montant> this.solde) {
			
			System.out.println("impossible car ya pas assez d'argent");
		}else {
			//this.solde-=montant; 
		    System.out.println(this.solde-=montant);
		}
		
	}
	

   
	public double decouverAutorise(double montant) {

			if (montantAutorise>montant) {
				return solde-=montant;
			}else {
				return 0; 
			    }
		  
		     }
		
  }
	


