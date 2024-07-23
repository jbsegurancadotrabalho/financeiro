package br.com.jbst.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.jbst.DTO.GetTurmasDTO;
import lombok.Data;

@Data
public class GetMatriculaPedidosDTO {
	private UUID idMatricula;
	private String venda;
	private BigDecimal valor;
	private String status;
	private String tipo_de_pagamento;
	private String observacoes;
	private GetFuncionarioDTOs funcionario;
	private GetTurmasDTO turmas;
}