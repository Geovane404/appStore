package com.gtecnologia.store.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gtecnologia.store.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError resp = new StandardError();
		resp.setTimestamp(Instant.now());
		resp.setStatus(status.value());
		resp.setError(error);
		resp.setMessage(e.getMessage());
		resp.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(resp);
	}
	
}
