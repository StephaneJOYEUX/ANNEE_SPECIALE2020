package com.iut.as.dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import com.iut.as.interfaces.IDaoEtudiant;
import com.iut.as.modele.Etudiant;
import com.iut.as.modele.factory.EtudiantFactory;

/***
 * La classe de persistance -> Ici de type mémoire.
 * 
 * @author stephane.joyeux
 *
 */
public class MemoireDaoEtudiant implements IDaoEtudiant {

	/* De type singleton */
	private static MemoireDaoEtudiant instance;

	private List<Etudiant> etudiants = null;

	/* Un constructeur privé pour empêcher l'instanciation direct */
	private MemoireDaoEtudiant() {
		// this.etudiants = new ArrayList<>();
		// ici je construit un étudiant --> Je pourrai le déléguer à une autre factory
		// ..
//		Etudiant etudiant = new Etudiant();
//		etudiant.setId(1);
//		etudiant.setNom("JOYEUX");
//		etudiant.setPrenom("Stéphane");
//		etudiants.add(etudiant);
		// Utilisation d'une factory qui me renvoie ma liste :
		// this.etudiants = EtudiantFactory.getList();
		this.etudiants = EtudiantFactory.getListEtudiants();
	}

	/* Création d'un singleton */
	/* Multi-Thread -> 1 unité d'exécution */
	/* empêche toute instanciation multiple même par différents threads. */
	public static synchronized MemoireDaoEtudiant getInstance() {
		if (instance == null) {
			instance = new MemoireDaoEtudiant();
		}
		return instance;
	}

	@Override
	public Etudiant read(int id) {
		// Pattern iterator !!
//		for (Etudiant etudiant : etudiants) {
//			if (etudiant.getId() == id) {
//				return etudiant;
//			}
//		}
		// Avec utilisation du pattern 'Itérator' ..
		// Parcourir une liste -> en faisant abstraction de son type ..
		Iterator<Etudiant> listEtudiants = this.etudiants.iterator();
		while (listEtudiants.hasNext()) {
			Object object = listEtudiants.next();
			if (object instanceof Etudiant) {
				Etudiant etudiant = (Etudiant) object;
				if (etudiant.getId() == id) {
					return etudiant;
				}
			}
		}
		return null;
	}

	@Override
	public List<Etudiant> getList() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Etudiant object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Etudiant object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void getEdudiantParCritere(String nom, String prenom) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Etudiant> getListeEtudiantsParDateNaissance(Date dateNaissance) {
		throw new UnsupportedOperationException();
	}
}
