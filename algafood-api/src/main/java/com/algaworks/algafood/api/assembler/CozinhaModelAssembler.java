package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.cozinha.CozinhaModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.restaurante.RestauranteModelOutput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CozinhaModelAssembler {

    //CozinhaModelAssembler é uma classe que transforma de entidade ex(Cozinha) para CozinhaModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public CozinhaModelOutput toModel(Cozinha cozinha) {
        return modelMapper.map(cozinha, CozinhaModelOutput.class);
    }

    public List<CozinhaModelOutput> toCollectionModel(List<Cozinha> cozinhas) {
        return cozinhas.stream().map(this::toModel).collect(Collectors.toList());
    }
}
