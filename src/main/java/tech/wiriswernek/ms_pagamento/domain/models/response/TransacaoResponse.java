package tech.wiriswernek.ms_pagamento.domain.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.enums.StatusTransacaoEnum;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransacaoResponse {
	private String uuid;
	private Double value;
	private String payer;
	private String payee;
	private StatusTransacaoEnum status;
}
