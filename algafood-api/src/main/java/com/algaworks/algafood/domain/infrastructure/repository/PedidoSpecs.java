package com.algaworks.algafood.domain.infrastructure.repository;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.repository.filter.PedidoFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PedidoSpecs {

    public static Specification<Pedido> usandoFiltro(PedidoFilter filtro) {
        return (root, query, builder) -> {
            if(Pedido.class.equals(query.getResultType())) {
                root.fetch("restaurante").fetch("cozinha");
                root.fetch("cliente");
            }
            /*
            Esses root acima resolve o problema do N + 1 muitos selects no banco, fazendo apenas um select só.
             */

            var predicates = new ArrayList<Predicate>();
            //Aqui adicionamos predicates no ArrayList

            if(filtro.getClienteId() != null) {
                predicates.add(builder.equal(root.get("cliente"), filtro.getClienteId())); //Aqui adicionei um predicate
            }

            if(filtro.getRestauranteId() != null) {
                predicates.add(builder.equal(root.get("restaurante"), filtro.getRestauranteId())); //Aqui adicionei um predicate
            }

            if(filtro.getDataCriacaoInicio() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoInicio())); //Aqui adicionei um predicate
            }

            if(filtro.getDataCriacaoFim() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoFim())); //Aqui adicionei um predicate
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
