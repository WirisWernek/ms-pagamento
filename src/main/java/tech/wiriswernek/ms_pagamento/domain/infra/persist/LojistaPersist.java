package tech.wiriswernek.ms_pagamento.domain.infra.persist;

import java.util.List;
import java.util.Optional;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Lojista;

public interface LojistaPersist {

	Lojista save(Lojista lojista);

	Optional<Lojista> findById(String id);

	List<Lojista> findAll();

	void deleteById(String id);
}
