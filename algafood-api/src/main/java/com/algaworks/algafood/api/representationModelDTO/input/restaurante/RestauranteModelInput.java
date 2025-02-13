package com.algaworks.algafood.api.representationModelDTO.input.restaurante;

import com.algaworks.algafood.api.representationModelDTO.input.endereco.EnderecoModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.restaurante.CozinhaIdInput;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class RestauranteModelInput {

    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private BigDecimal taxaFrete;

    @Valid
    @NotNull
    private CozinhaIdInput cozinha;

    @Valid
    @NotNull
    private EnderecoModelInput endereco;
}
