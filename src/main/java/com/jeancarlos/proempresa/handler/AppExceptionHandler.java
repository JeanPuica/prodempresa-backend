package com.jeancarlos.proempresa.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception e) {
		Map<String, String> errorReponse = Map.of("message", e.getLocalizedMessage(), "status",
				HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(errorReponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BadException.class)
	public ResponseEntity<Map<String, String>> handleBadException(BadException e) {
		Map<String, String> errorReponse = Map.of("message", e.getLocalizedMessage(), "status",
				e.getStatus().toString());
		return new ResponseEntity<>(errorReponse, e.getStatus());
	}
}
