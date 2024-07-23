package br.com.jbst.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.jbst.DTO.GetTurmasDTO;
import lombok.Data;

@Data
public class GetMatriculaFaturamentoPjDTO {
	private UUID idMatricula;
	private String venda;
	private String valor;
	private String status;
	private String observacoes;
	private String tipo_de_pagamento;
	private GetPessoaFisicaDTO pessoafisica;
	private GetTurmasDTO turmas;
}
