package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.produto.ProdutoModelOutput;
import com.algaworks.algafood.domain.model.Produto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProdutoModelAssembler {

    //ProdutoModelAssembler é uma classe que transforma de entidade ex(Produto) para ProdutoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public ProdutoModelOutput toModel(Produto produto) {
        return modelMapper.map(produto, ProdutoModelOutput.class);
    }

    public List<ProdutoModelOutput> toCollectionModel(List<Produto> produtos) {
        return produtos.stream().map(this::toModel).collect(Collectors.toList());
    }
}
