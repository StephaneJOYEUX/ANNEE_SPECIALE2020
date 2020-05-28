package com.iut.as.controller.facade;

import static com.iut.as.enumerations.EPersistance.MYSQL;
import static com.iut.as.factory.dao.DaoFactory.getDaoFactory;

import com.iut.as.exceptions.BankBusinessException;
import com.iut.as.factory.dao.DaoFactory;
import com.iut.as.modele.Client;

/***
 * Utilisation du design pattern 'Facade' qui cache la complexité de code.
 * 
 * @author stephane.joyeux
 *
 */
public class BankManager {

	private DaoFactory dao;

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
		Client client = dao.getDaoClient().readByKey(userCde);
		if (client == null) {
			System.out.println("Le client n'existe pas !");
			throw new BankBusinessException("userIsAllowed()", "- Utilisateur non trouvé - ");
		}
		boolean passwordOk = client.getPassword().equals(userPwd);
		if (passwordOk) {
			System.out.println("Le client existe et le mode de passe est correct !");
			return client;
		} else {
			System.out.println("Le client existe et le mode de passe est INcorrect !");
			throw new BankBusinessException("userIsAllowed()", "- Mot de passe incorrect - ");
		}
	}
}
