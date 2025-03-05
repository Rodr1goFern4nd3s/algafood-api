package com.algaworks.algafood.api.representationModelDTO.input.permissao;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class PermissaoModelInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;
}
