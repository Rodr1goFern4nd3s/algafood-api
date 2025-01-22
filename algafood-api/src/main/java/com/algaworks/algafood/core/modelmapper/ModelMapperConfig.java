package com.algaworks.algafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    //Agora temos uma instância de modelmapper dentro do nosso contexto do Spring
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
