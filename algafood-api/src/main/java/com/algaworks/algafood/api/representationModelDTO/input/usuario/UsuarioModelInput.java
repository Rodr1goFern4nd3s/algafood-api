package com.algaworks.algafood.api.representationModelDTO.input.usuario;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UsuarioModelInput {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;
}
