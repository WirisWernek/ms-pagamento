package tech.wiriswernek.ms_pagamento.domain.infra.persist;

import java.util.List;
import java.util.Optional;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Transacao;

public interface TransacaoPersist {

	Transacao save(Transacao transacao);

	Optional<Transacao> findById(String id);

	List<Transacao> findAll();

	void deleteById(String id);
}
