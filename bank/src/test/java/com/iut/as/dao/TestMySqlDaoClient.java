package com.iut.as.dao;

import static com.iut.as.enumerations.EPersistance.MYSQL;
import static com.iut.as.factory.DaoFactory.getDaoFactory;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.interfaces.IDaoClient;
import com.iut.as.modele.Client;

public class TestMySqlDaoClient {

	private IDaoClient dao;

	@Before
	public void setUp() throws Exception {
		// Je veux récupérer une instance de MySql :
		dao = getDaoFactory(MYSQL).getDaoClient();
	}

	@Test
	public void testDaoNotNull() {
		assertNotNull(dao);
	}
	
	@Test
	public void testRecupererListeClients() {
		List<Client> clients = dao.getListClient();
		assertNotNull(clients);
		assertFalse(clients.isEmpty());
	}
}