package tech.wiriswernek.ms_pagamento.domain.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.infra.persist.TransacaoPersist;
import tech.wiriswernek.ms_pagamento.domain.mapper.TransacaoMapper;
import tech.wiriswernek.ms_pagamento.domain.models.entity.Transacao;
import tech.wiriswernek.ms_pagamento.domain.models.enums.StatusTransacaoEnum;
import tech.wiriswernek.ms_pagamento.domain.models.request.TransacaoRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.TransacaoResponse;
import tech.wiriswernek.ms_pagamento.domain.service.TransacaoService;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

	private final TransacaoPersist transacaoPersist;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public TransacaoResponse criarTransacao(TransacaoRequest transacao) throws Exception {
		Transacao transacaoEntity = TransacaoMapper.toEntity(transacao);
		transacaoEntity.setQuando(LocalDateTime.now());
		transacaoEntity.setStatus(StatusTransacaoEnum.PENDENTE);
		transacaoEntity = transacaoPersist.save(transacaoEntity);
		return TransacaoMapper.toResponse(transacaoEntity);
	}

	@Override
	public TransacaoResponse buscarTransacaoPorId(String id) {
		var transacaoExistente = transacaoPersist.findById(id);
		transacaoExistente.orElseThrow(() -> new RuntimeException("Transação não encontrada"));
		return TransacaoMapper.toResponse(transacaoExistente.get());
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deletarTransacao(String id) {
		var transacaoExistente = transacaoPersist.findById(id);
		transacaoExistente.orElseThrow(() -> new RuntimeException("Transação não encontrada"));

		transacaoPersist.deleteById(id);
	}

	@Override
	public List<TransacaoResponse> listarTransacoes() {
		List<Transacao> transacoes = transacaoPersist.findAll();
		if (transacoes.isEmpty()) {
			return List.of();
		}
		return TransacaoMapper.toResponseList(transacoes);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void alterarStatusTransacao(String id, String status) {
		var transacaoExistente = transacaoPersist.findById(id);
		transacaoExistente.orElseThrow(() -> new RuntimeException("Transação não encontrada"));

		Transacao transacaoEntity = transacaoExistente.get();
		StatusTransacaoEnum statusEnum = StatusTransacaoEnum.fromString(status);
		transacaoEntity.setStatus(statusEnum);
		transacaoEntity.setUpdatedAt(LocalDateTime.now());
		transacaoPersist.save(transacaoEntity);
	}

}
