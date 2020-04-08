package com.iut.as.dao.factory;

import static com.iut.as.dao.factory.DaoFactory.getDaoFactory;
import static com.iut.as.enumerations.EPersistance.Memoire;
import static junit.framework.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * La classe de test dédiée à la factory ..
 * 
 * @author stephane.joyeux
 *
 */
public class TestDaoFactory {

	private DaoFactory daof;

	@Before
	public void setUp() {
		// On teste que la persistance en mémoire fonctionne !
		daof = getDaoFactory(Memoire);
	}

	@Test
	public void testDaof() {
		assertNotNull(daof);
		assertNotNull(daof.getDaoEtudiant());
	}
}
