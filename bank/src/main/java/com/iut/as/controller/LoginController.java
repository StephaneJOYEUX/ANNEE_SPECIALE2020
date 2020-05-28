package com.iut.as.controller;

import com.iut.as.controller.facade.BankManager;
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

	public LoginController() throws Exception {
		// On crée une instance de bank manager;
		manager = new BankManager();
	}

	private String userCde;
	private String userPwd;
	private String message;

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
		System.out.println("Je suis ici");
		System.out.println("Le paramètre 'userCde' = " + this.userCde);
		System.out.println("Le paramètre 'userPwd' = " + this.userPwd);
		if (manager.userIsAllowed(userCde, userPwd)) {
			setMessage("user est autorisé");
			return ActionSupport.SUCCESS;
		} else {
			setMessage("user est non autorisé");
			return ActionSupport.ERROR;
		}
	}
}
