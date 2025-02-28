package com.algaworks.algafood.api.representationModelDTO.output.restaurante;

import com.algaworks.algafood.api.representationModelDTO.output.cozinha.CozinhaModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.endereco.EnderecoModelOutput;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteModelOutput {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaModelOutput cozinha;
    private Boolean ativo;
    private Boolean aberto;
    private EnderecoModelOutput endereco;
}
