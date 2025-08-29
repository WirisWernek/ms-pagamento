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
@Table(name = "lojistas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lojista {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "saldo", nullable = false)
	private Double saldo;

	// @OneToMany(mappedBy = "lojista")
	// private List<Transacao> transacoes;
}
