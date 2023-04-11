package org.zerock.myapp.exception;

public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderException(String message) {
		super(message);
	}
	
	public OrderException(Exception originalException) {
		super(originalException);
	}
	
} // end class