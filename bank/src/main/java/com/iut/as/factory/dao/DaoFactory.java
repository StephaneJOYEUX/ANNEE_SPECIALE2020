package com.iut.as.factory.dao;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.as.enumerations.EPersistance;
import com.iut.as.interfaces.IDaoClient;
import com.iut.as.interfaces.IDaoCompte;

/**
 * // A LIRE ABSOLUMENT le cours '_06c_CoursDAO_20200408.pdf' !
 * 
 * @author stephane.joyeux
 *
 */
public abstract class DaoFactory {

	public static DaoFactory getDaoFactory(EPersistance cible) throws Exception {
		DaoFactory daoF = null;
		switch (cible) {
		case MEMOIRE:
			throw new NotYetImplementedException();
		case MYSQL:
			// Création de la session vers la base MySQL :
			return new MySqlDaoFactory();
		default:
			break;
		}
		return daoF;
	}

	// Le lien vers la table 'Compte' :
	public abstract IDaoCompte getDaoCompte();

	// Le lien vers la table 'Client' :
	public abstract IDaoClient getDaoClient();
}
