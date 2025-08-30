package com.gestaocartoes.repository;

import com.gestaocartoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    // Adicione este método para buscar transações por cartao_id
    List<Transacao> findByCartaoId(Long cartaoId);

}