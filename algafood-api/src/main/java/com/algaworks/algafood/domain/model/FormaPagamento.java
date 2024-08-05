package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "tab_formaPagamentos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FormaPagamento {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
}
