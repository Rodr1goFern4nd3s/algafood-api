package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.grupo.GrupoModelInput;
import com.algaworks.algafood.domain.model.Grupo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GrupoInputDesassembler {

    //GrupoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(GrupoModelInput) e monta uma entidade/objeto ex(Estado)

    private ModelMapper modelMapper;

    public Grupo toDomainObject(GrupoModelInput grupoModelInput) {
        return modelMapper.map(grupoModelInput, Grupo.class);
    }

    public void copyToDomainObject(GrupoModelInput grupoModelInput, Grupo grupo) {
        modelMapper.map(grupoModelInput, grupo);
    }
}
