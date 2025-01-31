package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.cidade.CidadeModelOutput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CidadeModelAssembler {

    //CidadeModelAssembler é uma classe que transforma de entidade ex(cidade) para CidadeModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public CidadeModelOutput toModel(Cidade cidade) {
        return modelMapper.map(cidade, CidadeModelOutput.class);
    }

    public List<CidadeModelOutput> toCollectionModel(List<Cidade> cidades) {
        return cidades.stream().map(this::toModel).collect(Collectors.toList());
    }
}
