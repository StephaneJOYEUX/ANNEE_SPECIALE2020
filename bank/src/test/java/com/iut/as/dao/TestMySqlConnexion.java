package com.iut.as.dao;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class TestMySqlConnexion {

	private static final String DB_NAME = "bankiut";

	@Test
	public void testConnexionOk() throws SQLException {
		Connection connection = MySqlConnexion.getInstance();
		assertNotNull(connection);
		assertEquals(DB_NAME, connection.getCatalog());
	}
}
