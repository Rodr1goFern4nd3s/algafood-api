package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.restaurante.RestauranteModelInput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteInputDesassembler {

    /*
    RestauranteInputDesassembler é uma classe que desmonta uma DTO de entrada ex(RestauranteModelInput) e monta uma entidade/objeto ex(Restaurante)
     */

    private ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteModelInput restauranteModelInput) {
        /*Fazendo dessa forma poderia ser muito mais código se a classe tiver muito mais propriedades
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteModelInput.getNome());
        restaurante.setTaxaFrete(restauranteModelInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteModelInput.getCozinhaId().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;*/

        //Usando a library ModelMapper
        return modelMapper.map(restauranteModelInput, Restaurante.class);
    }

    public void copyToDomainObject(RestauranteModelInput restauranteModelInput, Restaurante restaurante) {
        /*A idéia aqui é de converter um DTO input para um restaurante, passando um input e a entidade(destino) onde queremos atribuir
        O ModelMapper não irá instanciar uma nova entidade(restaurante), ele irá usá-lo copiar as propriedades de um objeto para o outro
        Use-o lá no método controller atualizar
         */

        //Para evitar org.hibernate.HibernateException: identifier of an instance of com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2
        restaurante.setCozinha(new Cozinha());

        //Para evitar org.hibernate.HibernateException: identifier of an instance of com.algaworks.algafood.domain.model.Cidade was altered from (Id atual) to (Por outro Id)
        if(restaurante.getEndereco() != null) {
            restaurante.getEndereco().setCidade(new Cidade());
        }

        modelMapper.map(restauranteModelInput, restaurante);
    }
}
