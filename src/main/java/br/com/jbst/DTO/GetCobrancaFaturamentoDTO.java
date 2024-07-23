package br.com.jbst.DTO;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.jbst.Config.InstantSerializer;
import lombok.Data;

@Data
public class GetCobrancaFaturamentoDTO {
    private UUID idCobranca;
	@JsonSerialize(using = InstantSerializer.class)
    private Instant dataHoraCriacao;
    private String responsavelCobranca;
    private String responsavelCliente;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant data_de_agendamento_pagamento;
    private String Assunto;
    private String Observacoes;	 
}
