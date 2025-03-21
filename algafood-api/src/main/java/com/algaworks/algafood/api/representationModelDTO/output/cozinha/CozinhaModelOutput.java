package com.algaworks.algafood.api.representationModelDTO.output.cozinha;

import com.algaworks.algafood.api.representationModelDTO.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class CozinhaModelOutput {

    @JsonView(RestauranteView.Resumo.class)
    private Long id;
    @JsonView(RestauranteView.Resumo.class)
    private String nome;
}
