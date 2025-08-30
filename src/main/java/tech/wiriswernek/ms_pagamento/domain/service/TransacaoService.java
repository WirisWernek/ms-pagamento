package tech.wiriswernek.ms_pagamento.domain.service;

import java.util.List;

import tech.wiriswernek.ms_pagamento.domain.models.request.TransacaoRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.TransacaoResponse;

public interface TransacaoService {
	TransacaoResponse criarTransacao(TransacaoRequest transacao) throws Exception;

	TransacaoResponse buscarTransacaoPorId(String id) throws Exception;

	void deletarTransacao(String id) throws Exception;

	List<TransacaoResponse> listarTransacoes();

	void alterarStatusTransacao(String id, String status) throws Exception;

}
