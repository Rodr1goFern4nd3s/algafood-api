package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.representationModelDTO.input.formaPagamento.FormaPagamentoModelInput;
import com.algaworks.algafood.domain.model.FormaPagamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FormaPagamentoInputDesassembler {
    /*
    FormaPagamentoInputDesassembler é uma classe que desmonta uma DTO de entrada ex(FormaPagamentoModelInput) e monta uma entidade/objeto ex(FormaPagamento)
     */

    private ModelMapper modelMapper;

    public FormaPagamento toDomainObject(FormaPagamentoModelInput formaPagamentoModelInput) {
        return modelMapper.map(formaPagamentoModelInput, FormaPagamento.class);
    }

    public void copyToDomainObject(FormaPagamentoModelInput formaPagamentoModelInput, FormaPagamento formaPagamento) {

        modelMapper.map(formaPagamentoModelInput, FormaPagamento.class);
    }
}
