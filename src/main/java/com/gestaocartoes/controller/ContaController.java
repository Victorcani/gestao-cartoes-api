package com.gestaocartoes.controller;

import com.gestaocartoes.model.Conta;
import com.gestaocartoes.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/{clienteId}")
    public Conta criarConta(@PathVariable Long clienteId, @RequestBody Conta conta) {
        return contaService.criarConta(clienteId, conta);
    }

    @GetMapping
    public List<Conta> listarContas() {
        return contaService.listarContas();
    }

    @PutMapping("/{id}")
    public Conta atualizarConta(@PathVariable Long id, @RequestBody Conta contaAtualizada) {
        return contaService.atualizarConta(id, contaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Long id) {
        contaService.deletarConta(id);
    }
}