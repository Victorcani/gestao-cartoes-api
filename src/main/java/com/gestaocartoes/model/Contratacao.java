package com.gestaocartoes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Muitas contratações podem ter o mesmo cliente
    @JoinColumn(name = "cliente_id") // chave estrangeira
    private Cliente cliente;

    @ManyToOne // Muitas contratações podem ter o mesmo cartão
    @JoinColumn(name = "cartao_id") // chave estrangeira
    private Cartao cartao;

    private LocalDate dataContratacao; // data da contratação
    private String status; // ativo ou cancelado

    public Contratacao() {}

    public Contratacao(Cliente cliente, Cartao cartao, LocalDate dataContratacao, String status) {
        this.cliente = cliente;
        this.cartao = cartao;
        this.dataContratacao = dataContratacao;
        this.status = status;
    }

    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}