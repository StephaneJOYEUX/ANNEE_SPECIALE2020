package com.iut.as.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * Classe permettant d'ouvrir une session vers la base de données MySQL.
 * 
 * @author stephane.joyeux
 *
 */
public class MySqlConnexion {

	public static Connection instance = null;
	// appel iut ..local host -> infodb.iutmetz.univ-lorraine.fr
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/bankiut";
	// C'est mal -> Les données sont lisibles ... !! (fichier properties ...)
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private MySqlConnexion() {
		// Pour éviter une instanciation directe :
	}

	public static Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = creerConnection();
			System.out.println("Connection établie avec le serveur - et la banque !");
		}
		return instance;
	}

	// Créer une 'session' vers la base de données :
	private static Connection creerConnection() throws SQLException {
		return DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
	}
}
