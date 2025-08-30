package com.gestaocartoes.repository;

import com.gestaocartoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    // Buscar todos os cartões de um cliente pelo ID
    List<Cartao> findByCliente_Id(Long clienteId);

}