package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.usuario.UsuarioModelInput;
import com.algaworks.algafood.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioInputDesassembler {

    /*
    UsuarioInputDesassembler é uma classe que desmonta uma DTO de entrada ex(UsuarioModelInput) e monta uma entidade/objeto ex(Usuario)
     */

    private ModelMapper modelMapper;

    public Usuario toDomainObject(UsuarioModelInput usuarioModelInput) {
        return modelMapper.map(usuarioModelInput, Usuario.class);
    }

    public void copyToDomainObject(UsuarioModelInput usuarioModelInput, Usuario usuario) {
        modelMapper.map(usuarioModelInput, usuario);
    }
}
