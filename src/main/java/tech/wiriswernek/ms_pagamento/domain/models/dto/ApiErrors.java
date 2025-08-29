package tech.wiriswernek.ms_pagamento.domain.models.dto;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class ApiErrors {

	private Set<String> message;

	public ApiErrors(String message) {
		this.message = Set.of(message);
	}

	public ApiErrors(List<String> messages) {
		this.message = Set.copyOf(messages);
	}

}
