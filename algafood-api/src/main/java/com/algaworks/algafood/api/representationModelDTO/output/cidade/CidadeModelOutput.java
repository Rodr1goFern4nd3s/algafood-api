package com.algaworks.algafood.api.representationModelDTO.output.cidade;

import com.algaworks.algafood.api.representationModelDTO.output.estado.EstadoModelOutput;
import lombok.Data;

@Data
public class CidadeModelOutput {

    private Long id;
    private String nome;
    private EstadoModelOutput estado;
}
