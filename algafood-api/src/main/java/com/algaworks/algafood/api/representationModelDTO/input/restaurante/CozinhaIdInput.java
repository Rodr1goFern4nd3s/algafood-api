package com.algaworks.algafood.api.representationModelDTO.input.restaurante;

import com.algaworks.algafood.core.validation.Groups;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CozinhaIdInput {
    /*
    CozinhaIdInput é so uma referência do ID da cozinha do restaurante
     */

    @NotNull
    private Long id;
}
