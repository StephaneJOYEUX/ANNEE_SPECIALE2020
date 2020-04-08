package com.iut.as.dao.factory;

import com.iut.as.dao.MemoireDaoEtudiant;
import com.iut.as.interfaces.IDaoEtudiant;

public class MemoireDaoFactory extends DaoFactory {

	@Override
	public IDaoEtudiant getDaoEtudiant() {
		// A chaque fois je créé une nouvelle instance de ma DAO !
		// return new MemoireDaoEtudiant();
		return MemoireDaoEtudiant.getInstance();
	}
}
