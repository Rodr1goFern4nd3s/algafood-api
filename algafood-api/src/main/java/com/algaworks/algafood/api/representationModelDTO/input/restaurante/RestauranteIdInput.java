package com.algaworks.algafood.api.representationModelDTO.input.restaurante;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RestauranteIdInput {

    @NotNull
    private Long id;
}
