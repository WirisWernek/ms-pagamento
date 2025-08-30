package tech.wiriswernek.ms_pagamento.domain.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoUsuarioEnum;

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

	@Column(name = "documento", nullable = false)
	private String documento;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "saldo", nullable = false)
	private Double saldo;

	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuarioEnum tipo;

	// @OneToMany(mappedBy = "usuario")
	// private List<Transacao> transacoes;
}
