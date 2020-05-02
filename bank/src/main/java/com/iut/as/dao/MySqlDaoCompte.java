package com.iut.as.dao;

import static com.iut.as.dao.MySqlConnexion.getInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Compte;
import com.iut.as.modele.CompteSansDecouvert;

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
		String mySQL = "SELECT * FROM compte WHERE numeroCompte = ?";
		try {
			PreparedStatement requete = connection.prepareStatement(mySQL);
			// Initialisation du paramètre N° 1 :
			requete.setString(1, key);
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				Compte compte = new CompteSansDecouvert(res.getString("numeroCompte"), res.getDouble("solde"));
				return compte;
			}
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
	public List<Compte> getComptes() {
		// Lire tous les comptes existant dans la Bdd;
		String mySQL = "SELECT * FROM compte";
		List<Compte> comptes = new ArrayList<>();
		try {
			PreparedStatement requete = connection.prepareStatement(mySQL);
			ResultSet res = requete.executeQuery();
			// Tant qu'un enregistrement existe :
			while (res.next()) {
				// Permet de récupérer la valeur d'un numéro de compte :
				String numeroCompte = res.getString("numeroCompte");
				// Non utilisé pour le moment :
				// String numeroClient = res.getString("userId");
				Double solde = res.getDouble("solde");
				// boolean decouvertAutorise = false;
				Compte compte = new CompteSansDecouvert(numeroCompte, solde);
				comptes.add(compte);
			}
		} catch (SQLException e) {
			System.out.println("Erreur " + e.getMessage());
		}
		return comptes;
	}
}
