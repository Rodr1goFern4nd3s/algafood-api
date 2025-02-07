package com.algaworks.algafood.api.representationModelDTO.input.formaPagamento;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FormaPagamentoModelInput {

    @NotBlank
    private String descricao;
}
