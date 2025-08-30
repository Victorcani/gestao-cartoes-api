package com.gestaocartoes.service;

import com.gestaocartoes.dto.ClienteRequest;
import com.gestaocartoes.model.Cliente;
import com.gestaocartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setDataNascimento(request.getDataNascimento());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> atualizarCliente(Long id, ClienteRequest request) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(request.getNome());
            cliente.setCpf(request.getCpf());
            cliente.setEmail(request.getEmail());
            cliente.setDataNascimento(request.getDataNascimento());
            return clienteRepository.save(cliente);
        });
    }

    public boolean deletarCliente(Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
    }
}
