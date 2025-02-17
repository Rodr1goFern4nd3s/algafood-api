package com.algaworks.algafood.api.representationModelDTO.input.grupo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GrupoModelInput {

    @NotBlank
    private String nome;
}
