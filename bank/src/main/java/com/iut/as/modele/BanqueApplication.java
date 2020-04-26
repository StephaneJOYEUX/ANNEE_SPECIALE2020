package com.iut.as.modele;
import java.util.*;

public class BanqueApplication {

	public static void main(String[] args) {
		
		
		System.out.println("................Compte 1....................");
		Client client1= new Client( "56565", "katia"," Metz 57000"); 
		Compte compte1 = new Compte(); 	
	    Bank b1=new Bank (compte1,client1);
	    System.out.println("la consulation de sole avant le dépot et retrait  :" + b1.Consultation("56565"));
	    b1.depot("56565", "katia",5000);
	    System.out.println("consultation du solde après dépot :" + b1.Consultation("56565"));        		
	    b1.retrait("56565", "katia",500);
	    System.out.println("consultation du solde après retrait :" + b1.Consultation("56565"));
	    System.out.println("le montant en euro est  :" + b1.conversionToEuro(2525) );
	    System.out.println("le montant en dolars est   :" + b1.conversionFromEuro(2565) );
	    b1.compte.debiter(500);
	    System.out.println("consultation apres créditer :" + b1.Consultation("56565"));  
	    
	   
	
		System.out.println("..............Compte 2...................");

	    Compte compte2= new Compte(); 
	    Client client2= new Client( "1919", "arwa"," Metz 57000"); 
	    Bank b2=new Bank (compte2,client2 );
	    System.out.println("la consulation de sole avant le dépot et retrait  :" + b2.Consultation("1919"));
	    b2.depot("1919", "arwa",4000);
	    System.out.println("consultation du solde après dépot :" + b2.Consultation("1919"));        		
	    b2.retrait("1919", "arwa",500);
	    System.out.println("consultation du solde après retrait :" + b2.Consultation("1919"));  
	    System.out.println("le montant en euro est  :" + b2.conversionToEuro(4300) );
	    System.out.println("le montant en dolars est   :" + b2.conversionFromEuro(3250));
	    b2.compte.crediter(200);
	    System.out.println("consultation apres créditer :" + b2.Consultation("1919"));  
	    b2.compte.debiter(300);
	    System.out.println("consultation apres créditer :" + b2.Consultation("1919"));
	    b2.compte.debiter(5000);
	}

}
