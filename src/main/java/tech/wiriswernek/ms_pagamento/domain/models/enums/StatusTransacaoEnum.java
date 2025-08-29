package tech.wiriswernek.ms_pagamento.domain.models.enums;

public enum StatusTransacaoEnum {
	PENDENTE,
	APROVADA,
	RECUSADA;

	public static StatusTransacaoEnum fromString(String status) {
		return switch (status) {
			case "PENDENTE" -> PENDENTE;
			case "APROVADA" -> APROVADA;
			case "RECUSADA" -> RECUSADA;
			default -> throw new IllegalArgumentException("Status inválido: " + status);
		};
	}

	public String toString() {
		return switch (this) {
			case PENDENTE -> "PENDENTE";
			case APROVADA -> "APROVADA";
			case RECUSADA -> "RECUSADA";
		};
	}
}
