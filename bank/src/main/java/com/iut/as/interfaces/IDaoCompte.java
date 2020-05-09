package com.iut.as.interfaces;

import java.util.List;

import com.iut.as.modele.Compte;

public interface IDaoCompte extends IDao<Compte> {

	// Récupération de tous les 'comptes' existants dans la base :
	List<Compte> getComptes();
	
	// Récupération des 'comptes' du client :
	List<Compte> getComptesByClient(String userId);
}
