package com.algaworks.algafood.api.mixin;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class RestauranteMixin {

    //Mixin criado somente para configuração de anotações jackson
    //Podemos utilizar as anotações do Jackson sem ser com uso de mixins, seria através do uso de DTOs
    //Após a criação do mixin é preciso, fazer a ligação entre Restaurante e RestauranteMixin que está no pacote "jackson"

    @JsonIgnoreProperties(value = "nome", allowGetters = true) //-> allowGetters irá ignorar o nome apenas na desserialização(conversão JSON para objeto)
    private Cozinha cozinha;

    @JsonIgnore
    private List<Produto> produtos;

    @JsonIgnore
    private Endereco endereco;

    //@JsonIgnore
    private OffsetDateTime dataCadastro;

    //@JsonIgnore
    private OffsetDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento;
}
