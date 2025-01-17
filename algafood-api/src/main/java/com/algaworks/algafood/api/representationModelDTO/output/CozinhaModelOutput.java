package com.algaworks.algafood.api.representationModelDTO.output;

import com.algaworks.algafood.core.validation.Groups;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CozinhaModelOutput {

    @NotNull(groups = Groups.CozinhaId.class)
    private Long id;

    @NotBlank
    private String nome;
}
