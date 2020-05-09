package com.iut.as.exceptions;

public class BankTechnicalException extends RuntimeException {

	private static final long serialVersionUID = -6712286890191246220L;

	public BankTechnicalException(String functionName, Exception e) {
		super(e);
		System.out.println("Une erreur 'technique' est survenue dans la fonction : '" + functionName + "'");
		System.out.println("L'erreur est : " + e.getMessage());
	}
}
