package com.iut.as.modele;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class Banque {

	// Attributs et donc les caractéristiques de notre banque
	// Liste non exhaustive :
	private int numero;
	private String reference;
	private String nom;

	// Une banque a une liste de clients.
	private List<Client> clients;
	// Une banque à une liste de comptes.
	private List<Compte> comptes;

	public int getNumero() {
		return numero;
	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}

	// Constructeur de l'objet 'Banque' :
	public Banque(int numero, String reference, String nom) {
		this.numero = numero;
		this.reference = reference;
		this.nom = nom;
		this.comptes = new ArrayList<>();
		this.clients = new ArrayList<>();
	}

	public boolean addClient(Client client) {
		throw new NotYetImplementedException();
	}

	public boolean addCompte(Compte compte) {
		throw new NotYetImplementedException();
	}

	public boolean retrait(String numCompte, String numClient, Double montant) {
		// Pas encore implémenté :
		throw new NotYetImplementedException();
	}

	public boolean depot(String numCompte, String numClient, Double montant) {
		// Pas encore implémenté :
		throw new NotYetImplementedException();
	}

	public boolean ouvertureCompte(String numeroClient) {
		throw new NotYetImplementedException();
	}
	
	public boolean fermetureCompte(String numeroClient, String numeroCompte) {
		throw new NotYetImplementedException();
	}

	public Double conversionFromEuro(Double montant) {
		throw new NotYetImplementedException();
	}

	public Double conversionToEuro(Double montant) {
		throw new NotYetImplementedException();
	}
}
