package com.algaworks.algafood.api.representationModelDTO.input.produto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class ProdutoModelInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NonNull
    @PositiveOrZero
    private BigDecimal preco;

    @NonNull
    private boolean ativo;
}
