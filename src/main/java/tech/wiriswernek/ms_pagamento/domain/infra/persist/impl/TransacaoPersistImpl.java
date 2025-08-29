package tech.wiriswernek.ms_pagamento.domain.infra.persist.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.infra.persist.TransacaoPersist;
import tech.wiriswernek.ms_pagamento.domain.infra.repository.TransacaoRepository;
import tech.wiriswernek.ms_pagamento.domain.models.entity.Transacao;

@Service
@RequiredArgsConstructor
public class TransacaoPersistImpl implements TransacaoPersist {

	private final TransacaoRepository transacaoRepository;

	@Override
	public Transacao save(Transacao transacao) {
		return transacaoRepository.save(transacao);
	}

	@Override
	public Optional<Transacao> findById(String id) {
		return transacaoRepository.findById(id);
	}

	@Override
	public List<Transacao> findAll() {
		return transacaoRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		transacaoRepository.deleteById(id);
	}

}
