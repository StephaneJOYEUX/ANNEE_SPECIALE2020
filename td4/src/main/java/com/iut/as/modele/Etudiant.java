package com.iut.as.modele;

import java.sql.Date;

public class Etudiant {

	private int id;

	private String nom;

	private String prenom;

	private Date dateNaissance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "id = " + this.id + " nom = " + this.nom + " prenom = " + this.prenom;
	}
}
