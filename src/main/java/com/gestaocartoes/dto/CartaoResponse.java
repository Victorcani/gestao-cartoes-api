package com.gestaocartoes.dto;

public class CartaoResponse {
    private Long id;
    private String nome;
    private String tipo;
    private double anuidade;
    private String bandeira;
    private String numero;
    private Long clienteId;

    public CartaoResponse() {}

    public CartaoResponse(Long id, String nome, String tipo, double anuidade,
                          String bandeira, String numero, Long clienteId) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.anuidade = anuidade;
        this.bandeira = bandeira;
        this.numero = numero;
        this.clienteId = clienteId;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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