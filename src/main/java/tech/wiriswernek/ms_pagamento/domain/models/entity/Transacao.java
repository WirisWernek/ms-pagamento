package tech.wiriswernek.ms_pagamento.domain.models.entity;

import java.time.LocalDateTime;

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
import tech.wiriswernek.ms_pagamento.domain.models.enums.StatusTransacaoEnum;
import tech.wiriswernek.ms_pagamento.domain.models.enums.TipoTransacaoEnum;

@Entity
@Table(name = "transacoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	@Column(name = "value", nullable = false)
	private Double value;

	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoTransacaoEnum tipo;

	@Column(name = "payer", nullable = false)
	private String payer;

	@Column(name = "payee", nullable = false)
	private String payee;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusTransacaoEnum status;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime quando;

	@Column(name = "updated_at", nullable = true)
	private LocalDateTime updatedAt;

	// @Column(name = "saldo_anterior_usuario", nullable = false)
	// private Double saldoAnteriorUsuario;

	// @Column(name = "saldo_anterior_lojista", nullable = false)
	// private Double saldoAnteriorLojista;

	// @Column(name = "saldo_atual_usuario", nullable = false)
	// private Double saldoAtualUsuario;

	// @Column(name = "saldo_atual_lojista", nullable = false)
	// private Double saldoAtualLojista;

}
