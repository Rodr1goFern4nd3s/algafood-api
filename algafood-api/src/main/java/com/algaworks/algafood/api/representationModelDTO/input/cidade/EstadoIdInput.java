package com.algaworks.algafood.api.representationModelDTO.input.cidade;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EstadoIdInput {

    @NotNull
    private Long id;
}
