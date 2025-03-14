package com.algaworks.algafood.api.representationModelDTO.input.pedido;

import com.algaworks.algafood.api.representationModelDTO.input.endereco.EnderecoModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.formaPagamento.FormaPagamentoIdInput;
import com.algaworks.algafood.api.representationModelDTO.input.intemPedido.ItemPedidoInput;
import com.algaworks.algafood.api.representationModelDTO.input.restaurante.RestauranteIdInput;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PedidoInput {

    @Valid
    @NotNull
    private RestauranteIdInput restaurante;

    @Valid
    @NotNull
    private EnderecoModelInput enderecoEntrega;

    @Valid
    @NotNull
    private FormaPagamentoIdInput formaPagamento;

    @Valid
    @Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;
}
