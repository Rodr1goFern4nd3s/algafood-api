package com.algaworks.algafood.api.representationModelDTO.input.formaPagamento;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FormaPagamentoIdInput {

    @NotNull
    private Long id;
}
