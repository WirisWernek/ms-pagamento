package tech.wiriswernek.ms_pagamento.domain.models.enums;

public enum TipoUsuarioEnum {
	PESSOA_FISICA,
	PESSOA_JURIDICA;
	
	public static TipoUsuarioEnum fromValue(String value) {
		try {
			return TipoUsuarioEnum.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			return PESSOA_FISICA;
		}
	}
}
