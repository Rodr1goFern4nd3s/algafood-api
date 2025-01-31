package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.estado.EstadoModelInput;
import com.algaworks.algafood.domain.model.Estado;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstadoInputDesassembler {
    /*
    EstadoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(EstadoModelInput) e monta uma entidade/objeto ex(Estado)
     */

    private ModelMapper modelMapper;

    public Estado toDomainObject(EstadoModelInput estadoModelInput) {
        return modelMapper.map(estadoModelInput, Estado.class);
    }

    public void copyToDomainObject(EstadoModelInput estadoModelInput, Estado estado) {
        /*A idéia aqui é de converter um DTO input para um estado, passando um input e a entidade(destino) onde queremos atribuir.
        O ModelMapper não irá instanciar uma nova entidade(estado), ele irá usá-lo copiar as propriedades de um objeto para o outro
        Use-o lá no método controller atualizar
         */

        modelMapper.map(estadoModelInput, estado);
    }
}
