package com.iut.as.interfaces;

import java.sql.Date;
import java.util.List;

import com.iut.as.modele.Etudiant;

public interface IDaoEtudiant extends IDao<Etudiant> {

	void getEdudiantParCritere(String nom, String prenom);

	List<Etudiant> getListeEtudiantsParDateNaissance(Date dateNaissance);
}
