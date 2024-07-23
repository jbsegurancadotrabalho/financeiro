package br.com.jbst.DTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.jbst.Config.InstantSerializer;
import br.com.jbst.entities.PessoaFisica;
import lombok.Data;

@Data
public class GetFaturamentopfDto {
    private UUID idfaturamentopf;
    private Integer numeroFaturamento;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant dataHoraCriacao;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant dataInicio;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant dataFim;
    private String venda;
    private String notafiscal;
    private String valor;
    private String comprador;
    private String telefone;
    private String email;
    private String responsavelfinanceiro;
    private String telefonefinanceiro;
    private String whatsapp;
    private String emailfinanceiro;
    private Instant data_de_pagamento;
    private String parcelas;
    private String forma_de_pagamento;
    private String observacoes;
    private List<RelatorioMatriculaDTO> matriculas;
    private BigDecimal total;
    private boolean faturaFechada;
    private List<GetCobrancaFaturamentoDTO> relatorios;
    private GetPessoaFisicaDTO pessoaFisica;

}
