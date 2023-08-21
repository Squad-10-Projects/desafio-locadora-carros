package com.example.demo.model.dto;

import com.example.demo.model.entities.InformacoesPagamento;
import jakarta.validation.constraints.*;

public class InformacoesPagamentoDTO {

    private Long id;
    @NotBlank(message = "O número do cartão não pode ser vazio")
    private String numeroCartao;
    @NotBlank(message = "A data de expiração não pode estar vazia")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "A data de expiração deve estar no formato MM/AA")
    private String dataExpiracao;
    @Min(value = 100, message = "O CVV deve ter pelo menos 3 dígitos")
    @Digits(integer = 4, fraction = 0, message = "O CVV deve ter entre 3 e 4 dígitos")
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