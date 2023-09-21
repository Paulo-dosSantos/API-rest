package br.com.testes.api_rest.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.testes.api_rest.services.exceptions.DataIntegratyViolationException;
import br.com.testes.api_rest.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>objectNotFound(
			ObjectNotFoundException ex, HttpServletRequest request
			
			){
		StandardError error= new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), 
			request.getRequestURI()	);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StandardError>dataIntegratyViolationException(
			DataIntegratyViolationException ex, HttpServletRequest request
			
			){
		StandardError error= new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), 
				request.getRequestURI()	);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

}
