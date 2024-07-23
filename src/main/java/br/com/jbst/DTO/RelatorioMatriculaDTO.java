package br.com.jbst.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RelatorioMatriculaDTO {
	  private Integer numeroMatricula;
	    private BigDecimal valor;
		private String venda;
		private String status;
		private GetPessoaFisicaDTO pessoafisica;
		private GetFuncionarioDTOs funcionario;
		private GetTurmasDTO turmas;
}
