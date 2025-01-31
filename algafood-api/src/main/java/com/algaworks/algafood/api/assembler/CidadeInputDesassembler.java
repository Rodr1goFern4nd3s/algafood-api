package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.cidade.CidadeModelInput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CidadeInputDesassembler {

    //CidadeInputDesassembler é uma classe que desmonta uma DTO de entrada ex(CidadeModelInput) e monta uma entidade/objeto ex(Cidade)

    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeModelInput cidadeModelInput) {
        return modelMapper.map(cidadeModelInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeModelInput cidadeModelInput, Cidade cidade) {
        /*A idéia aqui é de converter um DTO input para uma cidade, passando um input e a entidade(destino) onde queremos atribuir
        O ModelMapper não irá instanciar uma nova entidade(cidade), ele irá usá-lo copiar as propriedades de um objeto para o outro
        Use-o lá no método controller atualizar
         */

        //Para evitar org.hibernate.HibernateException: identifier of an instance of com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2
        cidade.setEstado(new Estado());

        modelMapper.map(cidadeModelInput, cidade);
    }
}
