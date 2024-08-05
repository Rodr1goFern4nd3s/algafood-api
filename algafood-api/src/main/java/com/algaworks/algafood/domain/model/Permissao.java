package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "tb_permissoes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
}
