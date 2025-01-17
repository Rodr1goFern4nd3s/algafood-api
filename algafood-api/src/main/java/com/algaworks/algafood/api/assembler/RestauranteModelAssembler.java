package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.CozinhaModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.RestauranteModelOutput;
import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteModelAssembler {

    /*
    RestauranteModelAssembler é uma classe que transforma de entidade ex(Restaurante) para RestauranteModelOutput ex(DTO de saída)
     */

    public RestauranteModelOutput toModel(Restaurante restaurante) {
        CozinhaModelOutput cozinhaModelOutput = new CozinhaModelOutput();
        cozinhaModelOutput.setId(restaurante.getCozinha().getId());
        cozinhaModelOutput.setNome(restaurante.getCozinha().getNome());

        RestauranteModelOutput restauranteModelOutput = new RestauranteModelOutput();
        restauranteModelOutput.setId(restaurante.getId());
        restauranteModelOutput.setNome(restaurante.getNome());
        restauranteModelOutput.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModelOutput.setCozinha(cozinhaModelOutput);

        return restauranteModelOutput;
    }

    public List<RestauranteModelOutput> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream().map(restaurante -> toModel(restaurante)).collect(Collectors.toList());
    }
}
