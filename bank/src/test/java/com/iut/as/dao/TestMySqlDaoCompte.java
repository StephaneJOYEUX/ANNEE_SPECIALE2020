package com.iut.as.dao;

import static com.iut.as.enumerations.EPersistance.MYSQL;
import static com.iut.as.factory.DaoFactory.getDaoFactory;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Compte;

/***
 * Classe de connection vers la table 'compte' de la base de données :
 * 
 * @author stephane.joyeux
 *
 */
public class TestMySqlDaoCompte {

	private IDaoCompte dao;

	@Before
	public void setUp() throws Exception {
		// Je veux récupérer une instance de MySql :
		dao = getDaoFactory(MYSQL).getDaoCompte();
	}

	@Test
	public void testDaoNotNull() {
		assertNotNull(dao);
	}

	@Test
	public void testRecupererListeComptes() {
		List<Compte> comptes = dao.getComptes();
		assertNotNull(comptes);
		assertFalse(comptes.isEmpty());
	}
}
