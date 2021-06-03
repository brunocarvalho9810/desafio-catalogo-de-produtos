package com.desafio.catalogo.model;

public class DefaultError {

	private Integer status_code;
	private String message;

	public DefaultError(Integer status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}

	public Integer getStatus_code() {
		return this.status_code;
	}

	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
