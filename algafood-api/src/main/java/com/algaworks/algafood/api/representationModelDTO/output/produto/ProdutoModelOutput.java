package com.algaworks.algafood.api.representationModelDTO.output.produto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoModelOutput {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean ativo;
}
