package tech.wiriswernek.ms_pagamento.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.request.TransacaoRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.TransacaoResponse;
import tech.wiriswernek.ms_pagamento.domain.service.TransacaoService;

@RestController
@RequestMapping("/api/transacoes")
@RequiredArgsConstructor
public class TransacaoController {

	private final TransacaoService transacaoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TransacaoResponse criarTransacao(@RequestBody TransacaoRequest transacaoRequest) throws Exception {
		return transacaoService.criarTransacao(transacaoRequest);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public TransacaoResponse buscarTransacaoPorId(@PathVariable String id) throws Exception {
		return transacaoService.buscarTransacaoPorId(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TransacaoResponse> listarTransacoes() {
		return transacaoService.listarTransacoes();
	}

	@PatchMapping("/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarTransacao(@PathVariable String id, @PathVariable String status) throws Exception {
		transacaoService.alterarStatusTransacao(id, status);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarTransacao(@PathVariable String id) throws Exception {
		transacaoService.deletarTransacao(id);
	}
}
