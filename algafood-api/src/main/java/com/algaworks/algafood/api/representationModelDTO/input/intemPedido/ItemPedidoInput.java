package com.algaworks.algafood.api.representationModelDTO.input.intemPedido;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ItemPedidoInput {

    @NotNull
    private Long produtoId;

    @NotNull
    @PositiveOrZero
    private Integer quantidade;

    private String observacao;
}
