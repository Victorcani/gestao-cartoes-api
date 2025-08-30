package com.gestaocartoes.model;

import jakarta.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;       // nome do cartão
    private String tipo;       // tipo: crédito ou débito
    private double anuidade;   // valor da anuidade
    private String bandeira;   // Visa, MasterCard, etc.
    private String numero;     // número do cartão

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Construtor vazio
    public Cartao() {}

    // Construtor completo
    public Cartao(String nome, String tipo, double anuidade, String bandeira, String numero, Cliente cliente) {
        this.nome = nome;
        this.tipo = tipo;
        this.anuidade = anuidade;
        this.bandeira = bandeira;
        this.numero = numero;
        this.cliente = cliente;
    }

    // GETTERS E SETTERS
    public Long getId() { return id; }

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

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}