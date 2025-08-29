package tech.wiriswernek.ms_pagamento.domain.infra.persist.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.infra.persist.UsuarioPersist;
import tech.wiriswernek.ms_pagamento.domain.infra.repository.UsuarioRepository;
import tech.wiriswernek.ms_pagamento.domain.models.entity.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioPersistImpl implements UsuarioPersist {

	private final UsuarioRepository usuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(String id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		usuarioRepository.deleteById(id);
	}

}
