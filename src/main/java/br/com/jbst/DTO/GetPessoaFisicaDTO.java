package br.com.jbst.DTO;


import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class GetPessoaFisicaDTO {
	private UUID idpessoafisica;
	private String pessoafisica;
	private String rg;
	private String cpf;
	private String telefone_1;
	private String telefone_2;
	private String email;
	private List<GetFaturamentopfDto> faturamento;
	public void setNome(Object nome) {
    
	}
}