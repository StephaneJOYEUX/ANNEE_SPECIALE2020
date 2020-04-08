package com.iut.as.dao;

import static com.iut.as.dao.factory.DaoFactory.getDaoFactory;
import static com.iut.as.enumerations.EPersistance.Memoire;
import static com.iut.as.modele.factory.EtudiantFactory.getListEtudiants;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.interfaces.IDaoEtudiant;
import com.iut.as.modele.Etudiant;

public class TestMemoireDaoEtudiant {

	private IDaoEtudiant dao;

	@Before
	public void setUp() {
		// On récupère par la factory une instance de daoEtudiant .. (en singleton).
		dao = getDaoFactory(Memoire).getDaoEtudiant();
	}

	@Test
	public void testDaoIsSingleton() {
		assertEquals(dao, getDaoFactory(Memoire).getDaoEtudiant());
	}

	@Test
	public void testReadById() {
		// Je récupère un étudiant par la factory étudiant !!
		Etudiant etudiant = getListEtudiants().get(0);
		// Je 'lis-read' un étudiant par la dao étudiant ...
		assertEquals(etudiant, dao.read(etudiant.getId()));
	}
}
