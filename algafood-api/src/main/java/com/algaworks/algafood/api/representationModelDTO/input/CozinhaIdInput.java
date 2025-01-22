package com.algaworks.algafood.api.representationModelDTO.input;

import com.algaworks.algafood.core.validation.Groups;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CozinhaIdInput {

    @NotNull(groups = Groups.CozinhaId.class)
    private Long id;
}
