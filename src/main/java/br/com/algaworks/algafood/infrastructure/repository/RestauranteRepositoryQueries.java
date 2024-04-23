package br.com.algaworks.algafood.infrastructure.repository;

import br.com.algaworks.algafood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {
    List<Restaurante> findNomeEFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}
