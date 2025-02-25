package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.produto.ProdutoModelInput;
import com.algaworks.algafood.domain.model.Produto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProdutoInputDesassembler {

    //ProdutoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(ProdutoModelInput) e monta uma entidade/objeto ex(Produto)

    private ModelMapper modelMapper;

    public Produto toDomainObject(ProdutoModelInput produtoModelInput) {
        return modelMapper.map(produtoModelInput, Produto.class);
    }

    public void copyToDomainObject(ProdutoModelInput produtoModelInput, Produto produto) {
        modelMapper.map(produtoModelInput, produto);
    }
}
