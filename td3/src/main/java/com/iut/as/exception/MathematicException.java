package com.iut.as.exception;

public class MathematicException extends RuntimeException {

	private static final long serialVersionUID = -1560818075741234090L;

	public MathematicException(String message) {
		super(message);
		System.out.println(message);
	}

	public MathematicException(ArithmeticException e, String message) {
		super(message, e);
		System.out.println(message);
	}
}
