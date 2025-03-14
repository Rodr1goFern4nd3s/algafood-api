package com.algaworks.algafood.api.representationModelDTO.output.pedido;

import com.algaworks.algafood.api.representationModelDTO.output.restaurante.RestauranteResumoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.usuario.UsuarioModelOutput;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class PedidoResumoModelOutput {
    private Long id;
    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    private String status;
    private OffsetDateTime dataCriacao;
    private RestauranteResumoModelOutput restaurante;
    private UsuarioModelOutput cliente;
}
