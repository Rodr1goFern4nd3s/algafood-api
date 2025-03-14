package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.representationModelDTO.input.intemPedido.ItemPedidoInput;
import com.algaworks.algafood.api.representationModelDTO.output.endereco.EnderecoModelOutput;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    //Agora temos uma instância de modelmapper dentro do nosso contexto do Spring
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(Endereco.class, EnderecoModelOutput.class);
        enderecoToEnderecoModelTypeMap.<String>addMapping(enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
                (enderecoModelOutputDestino, value) -> enderecoModelOutputDestino.getCidade().setEstado(value));
        /*
        Adicionamos esse mapeamento para a propriedade que chamamos de estado em CidadeResumoModel private String estado;
         */

        modelMapper.createTypeMap(ItemPedidoInput.class, ItemPedido.class)
                .addMappings(mapper -> mapper.skip(ItemPedido::setId));

        return modelMapper;
    }
    //Registramos um bean do Spring para fazer a injeção de ModelMapper
}
