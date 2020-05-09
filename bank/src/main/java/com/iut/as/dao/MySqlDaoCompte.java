package com.iut.as.dao;

import static com.iut.as.dao.BankConstants.DECOUVERT_AUTORISE;
import static com.iut.as.dao.BankConstants.MONTANT_DECOUVERT_AUTORISE;
import static com.iut.as.dao.BankConstants.NUMERO_COMPTE;
import static com.iut.as.dao.BankConstants.SOLDE;
import static com.iut.as.dao.MySqlConnexion.getInstance;
import static com.iut.as.enumerations.ETypeCompte.getTypeAccordingString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.as.enumerations.ETypeCompte;
import com.iut.as.factory.modele.CompteFactory;
import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Compte;

/***
 * @description : Dao vers la table Compte (Base MySql).
 * 
 * @author : stephane.joyeux
 *
 */
public class MySqlDaoCompte implements IDaoCompte {

	// Création d'un singleton pour éviter les instanciations multiples !
	// Ce qu'il y a de plus couteux !
	private static MySqlDaoCompte instance;

	// La connection vers la base de données :
	private Connection connection;

	// Création d'une instance de type singleton :
	public static MySqlDaoCompte getMySqlInstance() {
		if (instance == null) {
			instance = new MySqlDaoCompte();
			System.out.println("Connection à la table 'Compte' établie !");
		}
		return instance;
	}

	// Constructeur privé --> Donc on peut plus faire de 'new' :
	private MySqlDaoCompte() {
		try {
			connection = getInstance();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Connection à la banque est NON ok !");
		}
	}

	@Override
	public boolean create(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	public boolean update(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	public Compte readById(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public Compte readByKey(String key) {
		try {
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM compte WHERE numeroCompte = ?");
			requete.setString(1, key);
			return adapt(requete).get(0);
		} catch (SQLException e) {
			System.out.println("Erreur " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean delete(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	/* @return - Tous les comptes existant dans la Bdd. */
	public List<Compte> getComptes() {
		try {
			return adapt(connection.prepareStatement("SELECT * FROM compte"));
		} catch (SQLException e) {
			System.out.println("Erreur function getComptes() : " + e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	/* @return - Les comptes du client uniquement. */
	public List<Compte> getComptesByClient(String userId) {
		try {
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM compte WHERE userId = ?");
			// Initialisation du paramètre N° 1 :
			requete.setString(1, userId);
			return adapt(requete);
		} catch (SQLException e) {
			System.out.println("Erreur function getComptesByClient() :" + e.getMessage());
		}
		return new ArrayList<>();
	}

	/*
	 * Design Pattern 'Adapter' qui transforme un resultSet en un compte -> liste
	 * comptes.
	 */
	private List<Compte> adapt(PreparedStatement requete) throws SQLException {
		List<Compte> comptes = new ArrayList<>();
		ResultSet res = requete.executeQuery();
		while (res.next()) {
			String numCompte = res.getString(NUMERO_COMPTE);
			Double solde = res.getDouble(SOLDE);
			Double decouvertAutorise = res.getDouble(MONTANT_DECOUVERT_AUTORISE);
			String autorisationDecouvert = res.getString(DECOUVERT_AUTORISE);
			ETypeCompte typeCompte = getTypeAccordingString(autorisationDecouvert);
			comptes.add(CompteFactory.getCompte(typeCompte, numCompte, solde, decouvertAutorise));
		}
		return comptes;
	}
}
