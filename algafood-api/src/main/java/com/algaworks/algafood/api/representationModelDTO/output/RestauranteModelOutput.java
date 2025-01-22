package com.algaworks.algafood.api.representationModelDTO.output;

import com.algaworks.algafood.api.representationModelDTO.input.CozinhaIdInput;
import com.algaworks.algafood.core.validation.Groups;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;

@Data
public class RestauranteModelOutput {


    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaModelOutput cozinha;
}
