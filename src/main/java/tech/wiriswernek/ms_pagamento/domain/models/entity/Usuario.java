package tech.wiriswernek.ms_pagamento.domain.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "saldo", nullable = false)
	private Double saldo;

	// @OneToMany(mappedBy = "usuario")
	// private List<Transacao> transacoes;
}
