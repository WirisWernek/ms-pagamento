package tech.wiriswernek.ms_pagamento.domain.models.request;

public record TransacaoRequest(Double value, String payer, String payee, String descricao, String tipo) {

}
