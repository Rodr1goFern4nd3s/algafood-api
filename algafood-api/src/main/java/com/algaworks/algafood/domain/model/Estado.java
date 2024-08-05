package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_estados")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
}
