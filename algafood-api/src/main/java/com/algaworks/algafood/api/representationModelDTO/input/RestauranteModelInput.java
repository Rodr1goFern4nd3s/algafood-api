package com.algaworks.algafood.api.representationModelDTO.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteModelInput {

    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaIdInput cozinhaId;
}
