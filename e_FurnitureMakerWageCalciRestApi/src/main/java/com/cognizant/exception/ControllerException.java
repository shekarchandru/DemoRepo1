package com.cognizant.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4883752369862825568L;
	String errorCode;
	String errorMessage;
	
	
	public ControllerException() {
		super();
	}


	public ControllerException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String toString() {
		return "ControllerException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
