package tech.wiriswernek.ms_pagamento.domain.infra.persist;

import java.util.List;
import java.util.Optional;

import tech.wiriswernek.ms_pagamento.domain.models.entity.Usuario;

public interface UsuarioPersist {
	Usuario save(Usuario usuario);

	Optional<Usuario> findById(String id);

	List<Usuario> findAll();

	void deleteById(String id);
}
