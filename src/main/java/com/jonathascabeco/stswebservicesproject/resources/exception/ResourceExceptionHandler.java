package com.jonathascabeco.stswebservicesproject.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jonathascabeco.stswebservicesproject.services.exceptions.ObjectNotFoundExceptions;

@ControllerAdvice
//indica que essa classe trata possiveis erros nas requisições;
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExceptions.class)
	//padrao para tratamento de exceções;
	public ResponseEntity<StandardError> objNotFound(ObjectNotFoundExceptions e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);		
	}
}
