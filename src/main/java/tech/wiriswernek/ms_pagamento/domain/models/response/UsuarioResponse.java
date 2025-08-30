package tech.wiriswernek.ms_pagamento.domain.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoUsuarioEnum;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsuarioResponse {
	private String uuid;
	private String nome;
	private String email;
	private String documento;
	private TipoUsuarioEnum tipo;
}
