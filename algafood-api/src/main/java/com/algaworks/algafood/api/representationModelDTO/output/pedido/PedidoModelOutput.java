package com.algaworks.algafood.api.representationModelDTO.output.pedido;

import com.algaworks.algafood.api.representationModelDTO.output.endereco.EnderecoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.formaPagamento.FormaPagamentoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.itemPedido.ItemPedidoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.restaurante.RestauranteResumoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.usuario.UsuarioModelOutput;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class PedidoModelOutput {

    private Long id;
    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    private String status;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataConfirmacao;
    private OffsetDateTime dataEntrega;
    private OffsetDateTime dataCancelamento;
    private RestauranteResumoModelOutput restaurante;
    private UsuarioModelOutput cliente;
    private FormaPagamentoModelOutput formaPagamento;
    private EnderecoModelOutput enderecoEntrega;
    private List<ItemPedidoModelOutput> itens;
}
