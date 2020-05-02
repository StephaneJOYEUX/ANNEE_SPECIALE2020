package com.iut.as.dao;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.as.enumerations.EPersistance;
import com.iut.as.interfaces.IDaoCompte;

public abstract class DaoFactory {

	public static DaoFactory getDaoFactory(EPersistance cible) throws Exception {

		DaoFactory daoF = null;

		switch (cible) {
		case MEMOIRE:
			throw new NotYetImplementedException();
		case MYSQL:
			throw new NotYetImplementedException();
		default:
			break;
		}
		return daoF;
	}

	public abstract IDaoCompte getDaoCompte();
}
