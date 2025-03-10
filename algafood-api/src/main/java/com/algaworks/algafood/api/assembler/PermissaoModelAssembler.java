package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.permissao.PermissaoModelOutput;
import com.algaworks.algafood.domain.model.Permissao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PermissaoModelAssembler {

    //PermissaoModelAssembler é uma classe que transforma de entidade ex(Permissao) para PermissaoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public PermissaoModelOutput toModel(Permissao permissao) {
        return modelMapper.map(permissao, PermissaoModelOutput.class);
    }

    public List<PermissaoModelOutput> toCollectionModel(Collection<Permissao> permissoes) {
        return permissoes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
