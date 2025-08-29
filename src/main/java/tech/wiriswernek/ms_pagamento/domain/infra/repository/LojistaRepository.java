package tech.wiriswernek.ms_pagamento.domain.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Lojista;

public interface LojistaRepository extends JpaRepository<Lojista, String> {

}
