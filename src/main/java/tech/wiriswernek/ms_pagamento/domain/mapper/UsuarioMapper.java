package tech.wiriswernek.ms_pagamento.domain.mapper;

import java.util.List;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Usuario;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoUsuarioEnum;
import tech.wiriswernek.ms_pagamento.domain.models.request.UsuarioRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.UsuarioResponse;

public class UsuarioMapper {

	private UsuarioMapper() {
		// Private constructor to prevent instantiation
	}

	public static Usuario toEntity(UsuarioRequest request) {
		return Usuario.builder()
				.nome(request.nome())
				.email(request.email())
				.password(request.senha())
				.documento(request.documento())
				.tipo(TipoUsuarioEnum.fromValue(request.tipo()))
				.build();
	}

	public static UsuarioResponse toResponse(Usuario entity) {
		return UsuarioResponse.builder()
				.uuid(entity.getUuid())
				.nome(entity.getNome())
				.email(entity.getEmail())
				.documento(entity.getDocumento())
				.tipo(entity.getTipo())
				.build();
	}

	public static List<UsuarioResponse> toResponseList(List<Usuario> entities) {
		return entities.stream()
				.map(UsuarioMapper::toResponse)
				.toList();
	}
}
