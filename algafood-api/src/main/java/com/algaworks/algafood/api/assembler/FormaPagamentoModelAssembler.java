package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.output.formaPagamento.FormaPagamentoModelOutput;
import com.algaworks.algafood.domain.model.FormaPagamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FormaPagamentoModelAssembler {

    //FormaPagamentoModelAssembler é uma classe que transforma de entidade ex(FormaPagamento) para FormaPagamentoModelOutput ex(DTO de saída)

    private ModelMapper modelMapper;

    public FormaPagamentoModelOutput toModel(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamentoModelOutput.class);
    }

    public List<FormaPagamentoModelOutput> toCollectionModel(Collection<FormaPagamento> formasPagamentos) {
        return formasPagamentos.stream().map(formaPagamento -> toModel(formaPagamento)).collect(Collectors.toList());
    }
}
