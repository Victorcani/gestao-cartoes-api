package com.gestaocartoes.service;

import com.gestaocartoes.model.Conta;
import com.gestaocartoes.model.Cliente;
import com.gestaocartoes.repository.ContaRepository;
import com.gestaocartoes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Conta criarConta(Long clienteId, Conta conta) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        conta.setCliente(cliente);
        return contaRepository.save(conta);
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Conta atualizarConta(Long id, Conta contaAtualizada) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        conta.setNumero(contaAtualizada.getNumero());  // ✅ corrigido
        conta.setSaldo(contaAtualizada.getSaldo());    // ✅ corrigido

        return contaRepository.save(conta);
    }

    public void deletarConta(Long id) {
        contaRepository.deleteById(id);
    }
}