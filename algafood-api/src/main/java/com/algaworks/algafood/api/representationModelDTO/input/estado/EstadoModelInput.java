package com.algaworks.algafood.api.representationModelDTO.input.estado;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EstadoModelInput {

    @NotBlank
    private  String nome;
}
