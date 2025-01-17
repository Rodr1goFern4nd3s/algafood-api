package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.RestauranteModelInput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

public class RestauranteInputDesassembler {

    /*
    RestauranteInputdesassembler é uma classe que desmonta uma DTO de entrada ex(RestauranteModelInput) e monta uma Entidade ex(Restaurante)
     */

    public Restaurante toDomainObject(RestauranteModelInput restauranteModelInput) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteModelInput.getNome());
        restaurante.setTaxaFrete(restauranteModelInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteModelInput.getCozinhaId().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;
    }
}
