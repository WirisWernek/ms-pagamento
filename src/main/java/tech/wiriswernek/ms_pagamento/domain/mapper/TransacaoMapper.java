package tech.wiriswernek.ms_pagamento.domain.mapper;

import java.util.List;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Transacao;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoTransacaoEnum;
import tech.wiriswernek.ms_pagamento.domain.models.request.TransacaoRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.TransacaoResponse;

public class TransacaoMapper {

	private TransacaoMapper() {
		// Private constructor to prevent instantiation
	}

	public static Transacao toEntity(TransacaoRequest request) throws Exception {
		return Transacao.builder()
				.value(request.value())
				.payee(request.payee())
				.payer(request.payer())
				.descricao(request.descricao())
				.tipo(TipoTransacaoEnum.fromString(request.tipo()))
				.build();
	}

	public static TransacaoResponse toResponse(Transacao entity) {
		return TransacaoResponse.builder()
				.uuid(entity.getUuid())
				.value(entity.getValue())
				.payee(entity.getPayee())
				.payer(entity.getPayer())
				.status(entity.getStatus())
				.descricao(entity.getDescricao())
				.tipo(entity.getTipo())
				.build();
	}

	public static List<TransacaoResponse> toResponseList(List<Transacao> entities) {
		return entities.stream()
				.map(TransacaoMapper::toResponse)
				.toList();
	}
}
