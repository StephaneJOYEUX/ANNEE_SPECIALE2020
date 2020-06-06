package com.iut.as.controller.facade;

import static com.iut.as.enumerations.EPersistance.MYSQL;
import static com.iut.as.factory.dao.DaoFactory.getDaoFactory;

import java.util.List;

import org.apache.log4j.Logger;

import com.iut.as.exceptions.BankBusinessException;
import com.iut.as.factory.dao.DaoFactory;
import com.iut.as.modele.Client;
import com.iut.as.modele.Compte;

/***
 * Utilisation du design pattern 'Facade' qui cache la complexité de code.
 * 
 * @author stephane.joyeux
 *
 */
public class BankManager {

	private DaoFactory dao;

	private static final Logger logger = Logger.getLogger(BankManager.class);

	public BankManager() throws Exception {
		// Ici je me connecte à ma base de données.
		dao = getDaoFactory(MYSQL);
	}

	/**
	 * Fonction qui permet de savoir si un utilisateur existe et si le mot de passe
	 * est correct.
	 * 
	 * @param userCde
	 * @param userPwd
	 * @return
	 */
	public Client userIsAllowed(String userCde, String userPwd) {
		// 1er appel DB :
		logger.info("======= Appel DB");
		Client client = dao.getDaoClient().readByKey(userCde);
		if (client == null) {
			logger.info("Le client n'existe pas !");
			throw new BankBusinessException("userIsAllowed()", "- Utilisateur non trouvé - ");
		}
		boolean passwordOk = client.getPassword().equals(userPwd);
		if (passwordOk) {
			logger.info("Le client existe et le mode de passe est correct !");
			// Récupération de tous les comptes du client :
			// getComptesByClient(client);
			return client;
		} else {
			logger.error("Le client existe et le mode de passe est INcorrect !");
			throw new BankBusinessException("userIsAllowed()", "- Mot de passe incorrect - ");
		}
	}

	public List<Compte> getComptesByClient(String numeroClient) {
		// 2ème appel DB :
		logger.info("======= Appel DB");
		return dao.getDaoCompte().getComptesByClient(numeroClient);
	}

	public void getComptesByClient(Client client) {
		// 2ème appel DB :
		logger.info("======= Appel DB");
		List<Compte> comptes = dao.getDaoCompte().getComptesByClient(client.getNumeroClient());
		// Itération :
		for (Compte compte : comptes) {
			client.addCompte(compte);
		}
		if (client.getComptes() != null) {
			logger.info("le client possède : " + client.getComptes().size() + " compte(s)");
		}
	}
}
