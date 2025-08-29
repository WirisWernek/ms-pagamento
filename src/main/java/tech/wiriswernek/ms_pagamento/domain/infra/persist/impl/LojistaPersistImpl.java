package tech.wiriswernek.ms_pagamento.domain.infra.persist.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.infra.persist.LojistaPersist;
import tech.wiriswernek.ms_pagamento.domain.infra.repository.LojistaRepository;
import tech.wiriswernek.ms_pagamento.domain.models.entity.Lojista;

@Service
@RequiredArgsConstructor
public class LojistaPersistImpl implements LojistaPersist {

	private final LojistaRepository lojistaRepository;

	@Override
	public Lojista save(Lojista lojista) {
		return lojistaRepository.save(lojista);
	}

	@Override
	public Optional<Lojista> findById(String id) {
		return lojistaRepository.findById(id);
	}

	@Override
	public List<Lojista> findAll() {
		return lojistaRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		lojistaRepository.deleteById(id);
	}
}
