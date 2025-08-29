package tech.wiriswernek.ms_pagamento.domain.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {

}
