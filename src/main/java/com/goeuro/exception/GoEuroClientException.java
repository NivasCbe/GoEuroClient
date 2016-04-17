package com.goeuro.exception;

public class GoEuroClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8027771586150063983L;
	private static String exception_message;
	
	public GoEuroClientException(String message){
		this.exception_message=message;
	}

	public  String getException_message() {
		return exception_message;
	}


	

}
