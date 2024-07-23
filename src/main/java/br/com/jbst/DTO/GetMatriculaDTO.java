package br.com.jbst.DTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import   br.com.jbst.Config.InstantSerializer;
import lombok.Data;


@Data
public class GetMatriculaDTO {
	private UUID idMatricula;
    private Integer numeroMatricula;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant dataHoraCriacao;
	private String venda;
	private BigDecimal valor;
	private String status;
	private String tipo_de_pagamento;
	private String observacoes;
	private BigDecimal total;
	private GetPessoaFisicaDTO pessoafisica;
	private GetFuncionarioDTOs funcionario;
	private GetTurmasDTO turmas;
}
