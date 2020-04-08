package com.iut.as.dao.factory;

import com.iut.as.enumerations.EPersistance;
import com.iut.as.interfaces.IDaoEtudiant;

/***
 * Design Pattern 'Factory'
 * 
 * @author stephane.joyeux
 *
 */
public abstract class DaoFactory {

	/* @return 'une dao' qui correspond au type de la base de données. */
	public static DaoFactory getDaoFactory(EPersistance type) {
		DaoFactory daoF = null;
		switch (type) {
		case XML:
			throw new UnsupportedOperationException();
		case SQL:
			throw new UnsupportedOperationException();
		case Memoire:
			daoF = new MemoireDaoFactory();
			break;
		default:
			break;
		}
		return daoF;
	}

	public abstract IDaoEtudiant getDaoEtudiant();
}
