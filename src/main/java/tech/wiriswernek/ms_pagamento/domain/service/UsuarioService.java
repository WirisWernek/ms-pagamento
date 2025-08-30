package tech.wiriswernek.ms_pagamento.domain.service;

import java.util.List;

import tech.wiriswernek.ms_pagamento.domain.models.request.UsuarioRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.UsuarioResponse;

public interface UsuarioService {

	UsuarioResponse criarUsuario(UsuarioRequest usuario) throws Exception;

	UsuarioResponse buscarUsuarioPorId(String id) throws Exception;

	void atualizarUsuario(String id, UsuarioRequest usuario) throws Exception;

	void deletarUsuario(String id) throws Exception;

	List<UsuarioResponse> listarUsuarios();
}
