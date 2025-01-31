package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.restaurante.RestauranteModelOutput;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestauranteModelAssembler {

    /*
    RestauranteModelAssembler é uma classe que transforma de entidade ex(Restaurante) para RestauranteModelOutput ex(DTO de saída)

    Há uma possibilidade de melhorar esse código, usando uma biblioteca modelmapper
     */

    private ModelMapper modelMapper;

    public RestauranteModelOutput toModel(Restaurante restaurante) {

        /* Fazendo dessa forma poderia ser muito mais código se a classe tiver muito mais propriedades
        CozinhaModelOutput cozinhaModelOutput = new CozinhaModelOutput();
        cozinhaModelOutput.setId(restaurante.getCozinha().getId());
        cozinhaModelOutput.setNome(restaurante.getCozinha().getNome());

        RestauranteModelOutput restauranteModelOutput = new RestauranteModelOutput();
        restauranteModelOutput.setId(restaurante.getId());
        restauranteModelOutput.setNome(restaurante.getNome());
        restauranteModelOutput.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModelOutput.setCozinha(cozinhaModelOutput);
        return restauranteModelOutput;*/

        //Usando a library ModelMapper
        return modelMapper.map(restaurante, RestauranteModelOutput.class);
    }

    public List<RestauranteModelOutput> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
