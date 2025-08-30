package tech.wiriswernek.ms_pagamento.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.infra.persist.UsuarioPersist;
import tech.wiriswernek.ms_pagamento.domain.mapper.UsuarioMapper;
import tech.wiriswernek.ms_pagamento.domain.models.entity.Usuario;
import tech.wiriswernek.ms_pagamento.domain.models.request.UsuarioRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.UsuarioResponse;
import tech.wiriswernek.ms_pagamento.domain.service.UsuarioService;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioPersist usuarioPersist;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UsuarioResponse criarUsuario(UsuarioRequest usuario) throws Exception {
		Usuario usuarioEntity = UsuarioMapper.toEntity(usuario);
		usuarioEntity.setSaldo(0.0);
		usuarioEntity = usuarioPersist.save(usuarioEntity);
		return UsuarioMapper.toResponse(usuarioEntity);
	}

	@Override
	public UsuarioResponse buscarUsuarioPorId(String id) throws Exception {
		var usuario = usuarioPersist.findById(id);
		usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		return UsuarioMapper.toResponse(usuario.get());
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void atualizarUsuario(String id, UsuarioRequest usuario) throws Exception {

		var usuarioExistente = usuarioPersist.findById(id);
		usuarioExistente.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		Usuario usuarioEntity = usuarioExistente.get();
		usuarioEntity.setNome(usuario.nome());
		usuarioEntity.setEmail(usuario.email());
		usuarioPersist.save(usuarioEntity);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deletarUsuario(String id) throws Exception {
		var usuarioExistente = usuarioPersist.findById(id);
		usuarioExistente.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		usuarioPersist.deleteById(id);
	}

	@Override
	public List<UsuarioResponse> listarUsuarios() {
		List<Usuario> usuarios = usuarioPersist.findAll();
		if (usuarios.isEmpty()) {
			return List.of();
		}
		return UsuarioMapper.toResponseList(usuarios);
	}
}