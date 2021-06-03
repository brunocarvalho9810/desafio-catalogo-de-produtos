package com.desafio.catalogo.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafio.catalogo.model.DefaultError;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<DefaultError> erro = ex.getBindingResult().getFieldErrors().stream().map(error -> {
			return new DefaultError(HttpStatus.BAD_REQUEST.value(), error.getDefaultMessage());
		}).collect(Collectors.toList());

		return new ResponseEntity<Object>(erro, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		DefaultError erro = new DefaultError(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(erro, status);
	}

}