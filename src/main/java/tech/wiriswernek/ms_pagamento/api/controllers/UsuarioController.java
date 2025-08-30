package tech.wiriswernek.ms_pagamento.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.request.UsuarioRequest;
import tech.wiriswernek.ms_pagamento.domain.models.response.UsuarioResponse;
import tech.wiriswernek.ms_pagamento.domain.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest usuarioRequest) throws Exception{
		return usuarioService.criarUsuario(usuarioRequest);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponse buscarUsuarioPorId(@PathVariable String id) throws Exception{
		return usuarioService.buscarUsuarioPorId(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioResponse> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarUsuario(@PathVariable String id, @RequestBody UsuarioRequest usuarioRequest) throws Exception {
		usuarioService.atualizarUsuario(id, usuarioRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarUsuario(@PathVariable String id) throws Exception{
		usuarioService.deletarUsuario(id);
	}
}
