package com.algaworks.algafood.api.representationModelDTO.output.restaurante;

import com.algaworks.algafood.api.representationModelDTO.output.cozinha.CozinhaModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.endereco.EnderecoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteModelOutput {

    @JsonView({RestauranteView.Resumo.class, RestauranteView.ApenasNome.class})
    private Long id;

    @JsonView({RestauranteView.Resumo.class, RestauranteView.ApenasNome.class})
    private String nome;

    @JsonView(RestauranteView.Resumo.class)
    private BigDecimal taxaFrete;

    @JsonView(RestauranteView.Resumo.class)
    private CozinhaModelOutput cozinha;

    private Boolean ativo;
    private Boolean aberto;
    private EnderecoModelOutput endereco;
}
