package com.algaworks.algafood.api.representationModelDTO.input.usuario;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsuarioComSenhaInput extends UsuarioModelInput {

    @NotBlank
    private String senha;
}
