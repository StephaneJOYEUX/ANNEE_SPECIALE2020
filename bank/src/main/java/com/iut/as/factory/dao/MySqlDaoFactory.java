package com.iut.as.factory.dao;

import com.iut.as.dao.MySqlDaoClient;
import com.iut.as.dao.MySqlDaoCompte;
import com.iut.as.interfaces.IDaoClient;
import com.iut.as.interfaces.IDaoCompte;

public class MySqlDaoFactory extends DaoFactory {

	@Override
	public IDaoCompte getDaoCompte() {
		// Récupération d'une instance unique de la db vers la table 'compte' :
		// A LIRE ABSOLUMENT le cours '_06c_CoursDAO_20200408.pdf' !
		return MySqlDaoCompte.getMySqlInstance();
	}

	@Override
	public IDaoClient getDaoClient() {
		// Le lien vers la table client :
		return MySqlDaoClient.getMySqlInstance();
	}
}
