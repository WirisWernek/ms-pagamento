package tech.wiriswernek.ms_pagamento.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import tech.wiriswernek.ms_pagamento.core.exception.BusinessException;
import tech.wiriswernek.ms_pagamento.core.exception.ValidationException;
import tech.wiriswernek.ms_pagamento.domain.models.dto.ApiErrors;

@ControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ApiErrors handleValidationException(ValidationException ex) {
		return new ApiErrors(ex.getMessage());
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleBusinessException(BusinessException ex) {
		return new ApiErrors(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiErrors handleGenericException(Exception ex) {
		return new ApiErrors("An unexpected error occurred: " + ex.getMessage());
	}
}
