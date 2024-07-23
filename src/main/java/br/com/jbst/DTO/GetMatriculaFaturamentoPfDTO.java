package br.com.jbst.DTO;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import br.com.jbst.DTO.GetTurmasDTO;
import br.com.jbst.DTO.RelatorioMatriculaDTO;
import lombok.Data;

@Data
public class GetMatriculaFaturamentoPfDTO {

	private UUID idMatricula;	
	private String venda;
	private String valor;
	private String status;
	private String tipo_de_pagamento;
	private String observacoes;
	private GetPessoaFisicaDTO pessoafisica;
	private GetTurmasDTO turmas;
	private List<RelatorioMatriculaDTO> matriculas;
	private BigDecimal total;
	private List<GetCobrancaFaturamentoDTO> relatorio;
	public void setCobrancas(List<GetCobrancaFaturamentoDTO> cobrancas) {
	    this.relatorio = cobrancas;
	}
}