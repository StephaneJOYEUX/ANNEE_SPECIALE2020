package com.iut.as.dao;

import static com.iut.as.dao.BankConstants.NUMERO_COMPTE;
import static com.iut.as.dao.BankConstants.USER_ID;
import static com.iut.as.dao.MySqlConnexion.getInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.as.dto.CompteDto;
import com.iut.as.exceptions.BankTechnicalException;
import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Compte;

/***
 * @description : Dao vers la table Compte (Base MySql).
 * 
 * @author : stephane.joyeux
 *
 */
public class MySqlDaoCompte implements IDaoCompte {

	private static final String TABLE_NAME = "compte";

	// Création d'un singleton pour éviter les instanciations multiples !
	// Ce qu'il y a de plus couteux !
	private static MySqlDaoCompte instance;

	/* Data Transform Objet - Pattern Adapter */
	private CompteDto dto;

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
			dto = new CompteDto();
		} catch (SQLException e) {
			throw new BankTechnicalException("MySqlDaoCompte()", e);
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
	public boolean delete(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	/* @return 'un compte' du client . */
	public Compte readByKey(String key) {
		try {
			PreparedStatement requete = connection
					.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE " + NUMERO_COMPTE + " = ?");
			requete.setString(1, key);
			return dto.adapt(requete).get(0);
		} catch (SQLException | IndexOutOfBoundsException e) {
			throw new BankTechnicalException("readByKey()", e);
		}
	}

	@Override
	/* @return - Tous 'les comptes' existants dans la Bdd. */
	public List<Compte> getComptes() {
		try {
			return dto.adapt(connection.prepareStatement("SELECT * FROM " + TABLE_NAME));
		} catch (SQLException e) {
			throw new BankTechnicalException("getComptes()", e);
		}
	}

	@Override
	/* @return - Les 'comptes du client' uniquement. */
	public List<Compte> getComptesByClient(String userId) {
		try {
			PreparedStatement requete = connection
					.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE " + USER_ID + " = ?");
			// Initialisation du paramètre N° 1 :
			requete.setString(1, userId);
			return dto.adapt(requete);
		} catch (SQLException e) {
			throw new BankTechnicalException("getComptesByClient()", e);
		}
	}
}
