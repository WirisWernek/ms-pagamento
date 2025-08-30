package tech.wiriswernek.ms_pagamento.domain.models.request;

public record UsuarioRequest(String nome, String email, String documento, String senha, String tipo) {

}
