package com.algaworks.algafood.api.representationModelDTO.input.cidade;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CidadeModelInput {

    @NotBlank
    private String nome;

    @Valid
    @NotNull
    private EstadoIdInput estado;
}
