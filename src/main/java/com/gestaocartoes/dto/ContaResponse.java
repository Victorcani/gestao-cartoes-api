package com.gestaocartoes.dto;

import java.math.BigDecimal;

public class ContaResponse {
    private Long id;
    private String numeroConta;
    private BigDecimal saldo;
    private Long clienteId;

    public ContaResponse() {}

    public ContaResponse(Long id, String numeroConta, BigDecimal saldo, Long clienteId) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }
    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}