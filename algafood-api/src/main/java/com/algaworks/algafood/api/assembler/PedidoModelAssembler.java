package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.pedido.PedidoModelOutput;
import com.algaworks.algafood.domain.model.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PedidoModelAssembler {

    //PedidoModelAssembler é uma classe que transforma de entidade ex(Pedido) para PedidoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public PedidoModelOutput toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoModelOutput.class);
    }

    public List<PedidoModelOutput> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream().map(pedido -> toModel(pedido)).collect(Collectors.toList());
    }
}
