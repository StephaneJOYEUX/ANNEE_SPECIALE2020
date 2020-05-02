package com.iut.as.modele;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class Client {

	private String numeroClient;
	private String nom;
	private String adresse;

	// 1 Client possède 1 ou plusieurs comptes :
	// 1 client 'estTitulaire' de 1 ou plusieurs comptes.
	private List<Compte> comptes;

	public boolean addCompte(Compte compte) {
		throw new NotYetImplementedException();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroClient() {
		return numeroClient;
	}

	public String getNom() {
		return nom;
	}

	public Client(String numeroClient, String nom, String adresse) {
		this.numeroClient = numeroClient;
		this.nom = nom;
		this.adresse = adresse;
		this.comptes = new ArrayList<>();
	}
}
