package com.algaworks.algafood.api.representationModelDTO.input.usuario;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SenhaInput {

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String novaSenha;
}
