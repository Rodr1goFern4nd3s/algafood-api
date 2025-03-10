package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.usuario.UsuarioModelOutput;
import com.algaworks.algafood.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioModelAssembler {

    private ModelMapper modelMapper;

    public UsuarioModelOutput toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioModelOutput.class);
    }

    public List<UsuarioModelOutput> toCollectionModel(Collection<Usuario> usuarios) {
        return usuarios.stream().map(this::toModel).collect(Collectors.toList());
    }
}
