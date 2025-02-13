package com.algaworks.algafood.api.representationModelDTO.output.endereco;

import com.algaworks.algafood.api.representationModelDTO.output.cidade.CidadeModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.cidade.CidadeResumoModelOutput;
import lombok.Data;

@Data
public class EnderecoModelOutput {
    //Modelo de representação do endereço

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CidadeResumoModelOutput cidade;
}