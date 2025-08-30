package com.gestaocartoes.service;

import com.gestaocartoes.model.Cartao;
import com.gestaocartoes.model.Transacao;
import com.gestaocartoes.repository.CartaoRepository;
import com.gestaocartoes.repository.TransacaoRepository;
import com.gestaocartoes.dto.TransacaoRequest;
import com.gestaocartoes.dto.TransacaoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    // Cria e salva uma transação, retornando TransacaoResponse
    public TransacaoResponse salvar(TransacaoRequest request) {
        Cartao cartao = cartaoRepository.findById(request.getCartaoId())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        Transacao transacao = new Transacao();
        transacao.setValor(request.getValor());
        transacao.setDescricao(request.getDescricao());
        transacao.setData(LocalDateTime.now());
        transacao.setCartao(cartao);

        Transacao salva = transacaoRepository.save(transacao);
        return new TransacaoResponse(salva);
    }

    // Lista todas as transações
    public List<TransacaoResponse> listarTodas() {
        return transacaoRepository.findAll()
                .stream()
                .map(TransacaoResponse::new)
                .collect(Collectors.toList());
    }

    // Lista transações por cartaoId
    public List<TransacaoResponse> listarPorCartao(Long cartaoId) {
        return transacaoRepository.findByCartaoId(cartaoId)
                .stream()
                .map(TransacaoResponse::new)
                .collect(Collectors.toList());
    }
}