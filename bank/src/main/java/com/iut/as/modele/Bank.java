package com.iut.as.modele;
import java.util.*; 


public class Bank {
	
	
	public Compte compte;	
	public Client client ; 		
	
	public  double tauxDeChangeEnEuro = 1.08; 	
	public  double tauxDeChangeEnDolars = 1; 

	public Bank(Compte compte, Client client) {
		super();
		this.compte = compte;
		this.client = client;
	}

	public Bank() {
		super();
	}


	public void  retrait(String numClient,String nomClient, double montant) {
		  		compte.solde-= montant;
		}
	
	
	public void  depot(String numClient,String  nomClient, double montant) {
				compte.solde += montant;
				
	}

	public Compte  ouverturCompte(String nomClient) {
		
		 return new Compte(); 
    }
	
	 public double Consultation(String numCompte ) {
		 
		   return compte.getSolde();
		   
		}
	 
	 
	public double  conversionFromEuro( float montantReal) {
		
		return  montantReal * tauxDeChangeEnEuro; 
	}
	 
	public double   conversionToEuro(double montantReal) {
			
		return montantReal* tauxDeChangeEnDolars; 

	}

	@Override
	public String toString() {
			return "Bank [compte=" + compte + ", client=" + client + "]";
		}


	 
	
	
   
	
	
	
	
	    
	 


	
	 

	
	
	
}

