package com.gestaocartoes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    private LocalDateTime data;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    // Construtor vazio
    public Transacao() {}

    // Construtor completo (opcional)
    public Transacao(double valor, LocalDateTime data, String descricao, Cartao cartao) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.cartao = cartao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}