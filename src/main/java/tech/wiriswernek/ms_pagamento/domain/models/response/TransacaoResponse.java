package tech.wiriswernek.ms_pagamento.domain.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.enums.StatusTransacaoEnum;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoTransacaoEnum;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransacaoResponse {
	private String uuid;
	private Double value;
	private String payer;
	private String payee;
	private String descricao;
	private TipoTransacaoEnum tipo;
	private StatusTransacaoEnum status;
}
