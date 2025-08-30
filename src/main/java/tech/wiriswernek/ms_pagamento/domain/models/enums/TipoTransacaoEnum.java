package tech.wiriswernek.ms_pagamento.domain.models.enums;

public enum TipoTransacaoEnum {

	CONTA_PAGAMENTO,
	COMPRA_LOJA;

	public String getDescricao() {
		switch (this) {
			case CONTA_PAGAMENTO:
				return "Conta de Pagamento";
			case COMPRA_LOJA:
				return "Compra na Loja";
			default:
				return "Tipo de Transação Desconhecido";
		}
	}

	public static TipoTransacaoEnum fromString(String tipo) throws Exception {
		switch (tipo) {
			case "CONTA_PAGAMENTO":
				return CONTA_PAGAMENTO;
			case "COMPRA_LOJA":
				return COMPRA_LOJA;
			default:
				throw new IllegalArgumentException("Tipo de Transação Desconhecido: " + tipo);
		}
	}

	

}
