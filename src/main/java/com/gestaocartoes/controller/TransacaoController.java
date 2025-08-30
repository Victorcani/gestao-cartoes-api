package com.gestaocartoes.controller;

import com.gestaocartoes.dto.TransacaoRequest;
import com.gestaocartoes.dto.TransacaoResponse;
import com.gestaocartoes.service.TransacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    // Criar transação
    @PostMapping
    public TransacaoResponse criar(@RequestBody TransacaoRequest request) {
        return transacaoService.salvar(request);
    }

    // Listar todas as transações
    @GetMapping
    public List<TransacaoResponse> listarTodas() {
        return transacaoService.listarTodas();
    }

    // Buscar transações de um cartão específico
    @GetMapping("/cartao/{cartaoId}")
    public List<TransacaoResponse> listarPorCartao(@PathVariable Long cartaoId) {
        return transacaoService.listarPorCartao(cartaoId);
    }
}