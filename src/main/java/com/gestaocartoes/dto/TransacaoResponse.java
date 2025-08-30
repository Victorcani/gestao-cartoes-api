package com.gestaocartoes.dto;

import com.gestaocartoes.model.Cartao;
import com.gestaocartoes.model.Transacao;

import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;
    private double valor;
    private LocalDateTime data;
    private CartaoResponse cartao;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.data = transacao.getData();
        if (transacao.getCartao() != null) {
            this.cartao = new CartaoResponse(transacao.getCartao());
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    // Classe interna para retornar dados do cartão
    public static class CartaoResponse {
        private Long id;
        private String nome;
        private String numero;

        public CartaoResponse(Cartao cartao) {
            this.id = cartao.getId();
            this.nome = cartao.getNome();
            this.numero = cartao.getNumero();
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getNumero() {
            return numero;
        }
    }
}