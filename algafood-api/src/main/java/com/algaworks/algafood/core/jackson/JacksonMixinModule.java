package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.api.mixin.CidadeMixin;
import com.algaworks.algafood.api.mixin.CozinhaMixin;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.api.mixin.RestauranteMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {
    /*
    - SimpleModule é uma classe da lib do Jackson que contém diversas funcionalidades e nos permite utilizar alguns de seus métodos quando
    desta classe estendemos. O método que "liga" um mixin à nossa entidade é um deles.
    - Nessa classe(Module) vamos registrar os mixins que estamos usando, também registrar e desregistrar sereleziador e desserializador jackson
    */

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class); //Exemplo ligando outros mixins
    }
}
