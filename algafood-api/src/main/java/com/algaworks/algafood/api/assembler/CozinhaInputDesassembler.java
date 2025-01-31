package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.cozinha.CozinhaModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.restaurante.RestauranteModelInput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CozinhaInputDesassembler {
    /*
    CozinhaInputDesassembler é uma classe que desmonta uma DTO de entrada ex(CozinhaModelInput) e monta uma entidade/objeto ex(Cozinha)
     */

    private ModelMapper modelMapper;

    public Cozinha toDomainObject(CozinhaModelInput cozinhaModelInput) {
        return modelMapper.map(cozinhaModelInput, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaModelInput cozinhaModelInput, Cozinha cozinha) {
        /*A idéia aqui é de converter um DTO input para um restaurante, passando um input e a entidade(destino) onde queremos atribuir
        O ModelMapper não irá instanciar uma nova entidade(restaurante), ele irá usá-lo copiar as propriedades de um objeto para o outro
        Use-o lá no método controller atualizar
         */

        modelMapper.map(cozinhaModelInput, cozinha);
    }
}
