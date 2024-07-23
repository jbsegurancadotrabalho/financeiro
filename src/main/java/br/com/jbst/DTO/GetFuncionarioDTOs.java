package br.com.jbst.DTO;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class GetFuncionarioDTOs {

	private UUID idFuncionario;
	private Instant DataHoraCriacao;
	private String nome;
	private String cpf;
	private String rg;
	private String status;
	private GetFuncaoDTOs funcao;
	private GetEmpresaDTOs empresa;
}