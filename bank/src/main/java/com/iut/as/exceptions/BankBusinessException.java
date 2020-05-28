package com.iut.as.exceptions;

public class BankBusinessException extends RuntimeException {

	private static final long serialVersionUID = 4594698913800005924L;

	public BankBusinessException(String functionName, String message) {
		super(message);
		System.out.println("Une erreur 'métier' est survenue dans la fonction : '" + functionName + "'");
		System.out.println("L'erreur est : " + message);
	}

	public BankBusinessException(String functionName, Exception e) {
		super(e);
		System.out.println("Une erreur 'métier' est survenue dans la fonction : '" + functionName + "'");
		System.out.println("L'erreur est : " + e.getMessage());
	}
}
