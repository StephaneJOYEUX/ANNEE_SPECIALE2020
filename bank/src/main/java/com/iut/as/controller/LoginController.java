package com.iut.as.controller;

import static org.apache.log4j.Logger.getLogger;

import java.util.List;

import org.apache.log4j.Logger;

import com.iut.as.controller.facade.BankManager;
import com.iut.as.exceptions.BankBusinessException;
import com.iut.as.modele.Client;
import com.iut.as.modele.Compte;
import com.opensymphony.xwork2.ActionSupport;

/***
 * @description : Le 1er controleur de l'application :)
 * 
 * @author stephane.joyeux
 *
 */
public class LoginController extends ActionSupport {

	private static final long serialVersionUID = 5540616014690763867L;

	// Lien vers la facade :
	private BankManager manager;

	private static final Logger logger = getLogger(LoginController.class);

	// Informations de Login :
	private String numeroClient;

	private String userCde;
	private String userPwd;
	private String message;

	// Le client connecté :
	private Client clientConnecte;
	private List<Compte> comptesClient;

	public List<Compte> getComptesClient() {
		return comptesClient;
	}

	public void setComptesClient(List<Compte> comptesClient) {
		this.comptesClient = comptesClient;
	}

	// On a récupéré la liste des comptes :
	private boolean listeComptesOk;

	public boolean isListeComptesOk() {
		return listeComptesOk;
	}

	public String getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}

	/***
	 * Constructeur principal :
	 * 
	 * @throws Exception
	 */
	public LoginController() throws Exception {
		// On crée une instance de bank manager;
		manager = new BankManager();
		listeComptesOk = false;
	}

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
		logger.info("Demande de la liste des comptes ... pour le client : " + this.numeroClient);
		setComptesClient(manager.getComptesByClient(numeroClient));
		listeComptesOk = true;
		return ActionSupport.SUCCESS;
	}
}
