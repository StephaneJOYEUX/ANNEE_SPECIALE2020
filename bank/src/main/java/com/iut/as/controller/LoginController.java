package com.iut.as.controller;

import com.opensymphony.xwork2.ActionSupport;

/***
 * @description : Le 1er controleur de l'application :)
 * 
 * @author stephane.joyeux
 *
 */
public class LoginController extends ActionSupport {

	private static final long serialVersionUID = 5540616014690763867L;

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String connection() {
		System.out.println("Je suis connecté");
		setMessage("ça fonctionne");
		return ActionSupport.SUCCESS;
	}
}
