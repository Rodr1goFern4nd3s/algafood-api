package com.algaworks.algafood.api.representationModelDTO.output.itemPedido;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemPedidoModelOutput {
    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;
}
