package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.pedido.PedidoResumoModelOutput;
import com.algaworks.algafood.domain.model.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PedidoResumoModelAssembler {

    private ModelMapper modelMapper;

    public PedidoResumoModelOutput toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResumoModelOutput.class);
    }

    public List<PedidoResumoModelOutput> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> toModel(pedido))
                .collect(Collectors.toList());
    }
}
