package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.estado.EstadoModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.permissao.PermissaoModelInput;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Permissao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PermissaoInputDesassembler {

    //PermissaoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(PermissaoModelInput) e monta uma entidade/objeto ex(Permissao)

    private ModelMapper modelMapper;

    public Permissao toDomainObject(PermissaoModelInput permissaoModelInput) {
        return modelMapper.map(permissaoModelInput, Permissao.class);
    }

    public void copyToDomainObject(PermissaoModelInput permissaoModelInput, Permissao permissao) {
        modelMapper.map(permissaoModelInput, permissao);
    }
}
