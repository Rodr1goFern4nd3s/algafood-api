package br.com.algaworks.algafood.infrastructure.repository;

import br.com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNome(String nome); //Pode trazer mais de uma cozinha com o mesmo nome e colocando em uma lista!
    List<Cozinha> findTodasByNomeContaining(String nome); //Podemos fazer uma busca de um nome fazendo um like usando os %esquerda/direita% usando o Containing
    Optional<Cozinha> findByNome(String nome); //Traz apenas uma cozinha(única instância - objeto)
}
