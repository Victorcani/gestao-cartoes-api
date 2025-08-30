package com.gestaocartoes.service;

import com.gestaocartoes.dto.CartaoRequest;
import com.gestaocartoes.dto.CartaoResponse;
import com.gestaocartoes.model.Cartao;
import com.gestaocartoes.model.Cliente;
import com.gestaocartoes.repository.CartaoRepository;
import com.gestaocartoes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    public CartaoService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    // Criar cartão
    public CartaoResponse criarCartao(CartaoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setNome(request.getNome());
        cartao.setTipo(request.getTipo());
        cartao.setAnuidade(request.getAnuidade());
        cartao.setBandeira(request.getBandeira());
        cartao.setNumero(request.getNumero());
        cartao.setCliente(cliente);

        Cartao salvo = cartaoRepository.save(cartao);

        return new CartaoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getTipo(),
                salvo.getAnuidade(),
                salvo.getBandeira(),
                salvo.getNumero(),
                salvo.getCliente().getId()
        );
    }

    // Listar cartões
    public List<CartaoResponse> listarCartoes() {
        return cartaoRepository.findAll().stream()
                .map(c -> new CartaoResponse(
                        c.getId(),
                        c.getNome(),
                        c.getTipo(),
                        c.getAnuidade(),
                        c.getBandeira(),
                        c.getNumero(),
                        c.getCliente().getId()
                ))
                .collect(Collectors.toList());
    }

    // Buscar cartão por ID
    public CartaoResponse buscarPorId(Long id) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        return new CartaoResponse(
                cartao.getId(),
                cartao.getNome(),
                cartao.getTipo(),
                cartao.getAnuidade(),
                cartao.getBandeira(),
                cartao.getNumero(),
                cartao.getCliente().getId()
        );
    }

    // Atualizar cartão
    public CartaoResponse atualizarCartao(Long id, CartaoRequest request) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        cartao.setNome(request.getNome());
        cartao.setTipo(request.getTipo());
        cartao.setAnuidade(request.getAnuidade());
        cartao.setBandeira(request.getBandeira());
        cartao.setNumero(request.getNumero());

        Cartao atualizado = cartaoRepository.save(cartao);

        return new CartaoResponse(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getTipo(),
                atualizado.getAnuidade(),
                atualizado.getBandeira(),
                atualizado.getNumero(),
                atualizado.getCliente().getId()
        );
    }

    // Deletar cartão
    public void deletarCartao(Long id) {
        if (!cartaoRepository.existsById(id)) {
            throw new RuntimeException("Cartão não encontrado");
        }
        cartaoRepository.deleteById(id);
    }
}