package com.gestaocartoes.controller;

import com.gestaocartoes.dto.CartaoRequest;
import com.gestaocartoes.dto.CartaoResponse;
import com.gestaocartoes.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    // Criar cartão
    @PostMapping
    public ResponseEntity<CartaoResponse> criar(@RequestBody CartaoRequest request) {
        CartaoResponse response = cartaoService.criarCartao(request);
        return ResponseEntity.ok(response);
    }

    // Listar todos os cartões
    @GetMapping
    public ResponseEntity<List<CartaoResponse>> listar() {
        return ResponseEntity.ok(cartaoService.listarCartoes());
    }

    // Buscar cartão por ID
    @GetMapping("/{id}")
    public ResponseEntity<CartaoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cartaoService.buscarPorId(id));
    }

    // Atualizar cartão
    @PutMapping("/{id}")
    public ResponseEntity<CartaoResponse> atualizar(@PathVariable Long id, @RequestBody CartaoRequest request) {
        return ResponseEntity.ok(cartaoService.atualizarCartao(id, request));
    }

    // Deletar cartão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletarCartao(id);
        return ResponseEntity.noContent().build();
    }
}