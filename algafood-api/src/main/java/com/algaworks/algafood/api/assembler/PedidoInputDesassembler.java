package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.pedido.PedidoInput;
import com.algaworks.algafood.domain.model.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PedidoInputDesassembler {
    /*
        PedidoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(PedidoInput) e monta uma entidade/objeto ex(Pedido)
     */

    private ModelMapper modelMapper;

    public Pedido toDomainObject(PedidoInput pedidoInput) {
        return modelMapper.map(pedidoInput, Pedido.class);
    }

    public void copyToDomainObject(PedidoInput pedidoInput, Pedido pedido) {
        modelMapper.map(pedidoInput, pedido);
    }
}
