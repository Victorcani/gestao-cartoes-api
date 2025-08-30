package com.gestaocartoes.dto;

public class CartaoRequest {

    private String nome;
    private String tipo;
    private double anuidade;
    private String bandeira;
    private String numero;
    private Long clienteId; // ID do cliente

    public CartaoRequest() {}

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getAnuidade() { return anuidade; }
    public void setAnuidade(double anuidade) { this.anuidade = anuidade; }
    public String getBandeira() { return bandeira; }
    public void setBandeira(String bandeira) { this.bandeira = bandeira; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}
