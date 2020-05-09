package com.iut.as.dao;

import static com.iut.as.enumerations.EPersistance.MYSQL;
import static com.iut.as.factory.dao.DaoFactory.getDaoFactory;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.exceptions.BankTechnicalException;
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

	private static final String TEST_NUMERO_COMPTE = "AB7328887341";

	private static final String NUMERO_COMPTE_EXISTE_PAS = "unnumerocomptequiexistepas";

	@Before
	public void setUp() throws Exception {
		// Je veux récupérer une instance de MySql :
		dao = getDaoFactory(MYSQL).getDaoCompte();
	}

	@Test
	public void testDaoNotNull() {
		assertNotNull(dao);
	}

	@Test(expected = BankTechnicalException.class)
	public void testRecupererUnCompteQuiExistePas() {
		assertNotNull(dao.readByKey(NUMERO_COMPTE_EXISTE_PAS));
	}

	@Test
	public void testRecupererListeComptes() {
		List<Compte> comptes = dao.getComptes();
		assertNotNull(comptes);
		assertFalse(comptes.isEmpty());
	}

	@Test
	public void testReadByKey() {
		Compte compte = dao.readByKey(TEST_NUMERO_COMPTE);
		assertNotNull(compte);
		assertEquals(TEST_NUMERO_COMPTE, compte.getNumCompte());
		assertTrue(compte.decouvertAutorise());
	}
}
