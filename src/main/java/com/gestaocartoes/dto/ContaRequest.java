package com.gestaocartoes.dto;

import java.math.BigDecimal;

public class ContaRequest {
    private String numeroConta;
    private BigDecimal saldoInicial;
    private Long clienteId;

    public ContaRequest() {}

    // Getters e Setters
    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }
    public BigDecimal getSaldoInicial() { return saldoInicial; }
    public void setSaldoInicial(BigDecimal saldoInicial) { this.saldoInicial = saldoInicial; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}