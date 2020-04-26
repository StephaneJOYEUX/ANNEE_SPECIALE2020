package com.iut.as.modele;

public class Client{
	public String numClient; 
	public String nomClient; 
	public String adresse;
	
	
	public Client() {
		
	}
	

	public Client(String numClient, String nomClient, String adresse) {
		super();
		this.numClient = numClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
	}

	public String getNumClient() {
		return numClient;
	}

	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}

	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setNom(String nom) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Client [numClient=" + numClient + ", nomClient=" + nomClient + ", adresse=" + adresse +  "]";
	}
	
	
	
	
	
	
	
	
	
	

}
