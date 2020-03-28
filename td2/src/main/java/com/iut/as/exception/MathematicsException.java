package com.iut.as.exception;

public class MathematicsException extends RuntimeException {

	private static final long serialVersionUID = -1560818075741234090L;

	public MathematicsException(String message) {
		super(message);
	}

	public MathematicsException(ArithmeticException e, String message) {
		super(message, e);
	}
}
