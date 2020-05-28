package com.iut.as.controller.facade;

import static com.iut.as.enumerations.EPersistance.MYSQL;

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
		dao = DaoFactory.getDaoFactory(MYSQL);
	}

	public boolean userIsAllowed(String userCde, String userPwd) {
		Client client = dao.getDaoClient().readByKey(userCde);
		if (client == null) {
			return false;
			// throw new BankBusinessException("userIsAllowed()", "Utilisateur non trouvé");
		}
		return client.getPassword().equals(userPwd);
	}
}
