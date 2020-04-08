package com.iut.as.modele.factory;

import java.util.ArrayList;
import java.util.List;

import com.iut.as.modele.Etudiant;

public class EtudiantFactory {

	private static List<Etudiant> etudiants;

	/* rendre la liste singleton */
	public static List<Etudiant> getListEtudiants() {
		if (etudiants == null) {
			etudiants = getList();
		}
		return etudiants;
	}

	private static List<Etudiant> getList() {
		List<Etudiant> etudiants = new ArrayList<>();
		// ici je construit un étudiant --> Je porrai le déléguer à une autre factory ..
		Etudiant etudiant = new Etudiant();
		etudiant.setId(1);
		etudiant.setNom("JOYEUX");
		etudiant.setPrenom("Stéphane");
		etudiants.add(etudiant);
		Etudiant etudiant2 = new Etudiant();
		etudiant2.setId(2);
		etudiant2.setNom("JOYEUX");
		etudiant2.setPrenom("Julie");
		etudiants.add(etudiant2);
		return etudiants;
	}

}
