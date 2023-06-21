package com.jeancarlos.proempresa.handler;

import org.springframework.http.HttpStatus;

public class BadException extends Exception {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	private final String message;
	
	public BadException(String message) {
		this.message = message;
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public BadException(HttpStatus status, String message) {
		this.message = message;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
