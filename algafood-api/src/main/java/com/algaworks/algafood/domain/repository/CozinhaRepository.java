package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    //List<Cozinha> findPesquisaExataByNome(String nome);
    //Page<Cozinha> findTodasByNomeContaining(String nome, Pageable pageble); Caso eu precise adicionar paginação em algum metodo implementado pelo SpringDataJpa
    Optional<Cozinha> findPesquisaExataByNome(String nomeCozinha);
}
