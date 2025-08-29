package tech.wiriswernek.ms_pagamento.core.exception;

public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException() {
		super("A business error occurred.");
	}

}
