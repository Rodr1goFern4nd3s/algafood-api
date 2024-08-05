package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tab_restaurantes")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurantes {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    @ManyToOne
    private Cozinha cozinha;
}
