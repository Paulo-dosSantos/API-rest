package br.com.testes.api_rest.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public DataIntegratyViolationException(String msg) {
		super(msg);
	}

}
