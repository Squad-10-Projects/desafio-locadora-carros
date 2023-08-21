package com.desafio.locadora.model.dto;

import com.desafio.locadora.model.entities.InformacoesPagamento;

public class InformacoesPagamentoDTO {

    private Long id;
    private String numeroCartao;
    private String dataExpiracao;
    private int cvv;

    public InformacoesPagamentoDTO() {
    }

    public InformacoesPagamentoDTO(InformacoesPagamento entity) {
        this.id = entity.getId();
        this.numeroCartao = entity.getNumeroCartao();
        this.dataExpiracao = entity.getDataExpiracao();
        this.cvv = entity.getCvv();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}