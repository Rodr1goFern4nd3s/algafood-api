package com.algaworks.algafood.api.representationModelDTO.input.cozinha;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CozinhaModelInput {

    @NotBlank
    private String nome;

}
