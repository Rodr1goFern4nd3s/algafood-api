package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.grupo.GrupoModelOutput;
import com.algaworks.algafood.domain.model.Grupo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GrupoModelAssembler {

    //GrupoModelAssembler é uma classe que transforma de entidade ex(Grupo) para GrupoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public GrupoModelOutput toModel(Grupo grupo) {
        return modelMapper.map(grupo, GrupoModelOutput.class);
    }

    public List<GrupoModelOutput> toCollectionModel(Collection<Grupo> grupos) {
        return grupos.stream().map(this::toModel).collect(Collectors.toList());
    }
}
