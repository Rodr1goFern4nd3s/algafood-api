package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.RestauranteModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.RestauranteModelOutput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteInputDesassembler {

    /*
    RestauranteInputDesassembler é uma classe que desmonta uma DTO de entrada ex(RestauranteModelInput) e monta uma entidade/objeto ex(Restaurante)
     */

    private ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteModelInput restauranteModelInput) {
        /*Fazendo dessa forma poderia ser muito mais código se a classe tiver muito mais propriedades
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteModelInput.getNome());
        restaurante.setTaxaFrete(restauranteModelInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteModelInput.getCozinhaId().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;*/

        //Usando a library ModelMapper
        return modelMapper.map(restauranteModelInput, Restaurante.class);
    }
}
