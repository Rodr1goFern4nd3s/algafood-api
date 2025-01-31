package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.estado.EstadoModelOutput;
import com.algaworks.algafood.domain.model.Estado;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EstadoModelAssembler {

    //EstadoModelAssembler é uma classe que transforma de entidade ex(Estado) para EstadoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public EstadoModelOutput toModel(Estado estado) {
        return modelMapper.map(estado, EstadoModelOutput.class);
    }

    public List<EstadoModelOutput> toCollectionModel(List<Estado> estados) {
        return estados.stream().map(this::toModel).collect(Collectors.toList());
    }
}
