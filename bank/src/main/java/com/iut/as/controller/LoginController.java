package com.iut.as.controller;

import static org.apache.log4j.Logger.getLogger;

import org.apache.log4j.Logger;

import com.iut.as.controller.facade.BankManager;
import com.iut.as.exceptions.BankBusinessException;
import com.iut.as.modele.Client;
import com.opensymphony.xwork2.ActionSupport;

/***
 * @description : Le 1er controleur de l'application :)
 * 
 * @author stephane.joyeux
 *
 */
public class LoginController extends ActionSupport {

	private static final long serialVersionUID = 5540616014690763867L;

	private BankManager manager;

	private static final Logger logger = getLogger(LoginController.class);

	public LoginController() throws Exception {
		// On crée une instance de bank manager;
		manager = new BankManager();
	}

	private String userCde;
	private String userPwd;
	private String message;

	private Client clientConnecte;

	public Client getClientConnecte() {
		return clientConnecte;
	}

	public void setClientConnecte(Client clientConnecte) {
		this.clientConnecte = clientConnecte;
	}

	public String getUserCde() {
		return userCde;
	}

	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * Utilisation de la fonction quand click sur le bouton 'submit' de la page
	 * index.jsp
	 */

	public String connection() {
		logger.info("Le paramètre 'userCde' = " + this.userCde);
		logger.info("Le paramètre 'userPwd' = " + this.userPwd);
		try {
			Client client = manager.userIsAllowed(userCde, userPwd);
			setMessage("user est autorisé");
			logger.info(client.toString());
			setClientConnecte(client);
			return ActionSupport.SUCCESS;
		} catch (BankBusinessException e) {
			setMessage("user est non autorisé");
			return ActionSupport.ERROR;
		}
	}

	public String listeComptes() {
		logger.info("Demande de la liste des comptes ... ");

		return ActionSupport.SUCCESS;
	}
}
