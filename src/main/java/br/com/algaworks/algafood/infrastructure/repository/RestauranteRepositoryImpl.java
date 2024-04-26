package br.com.algaworks.algafood.infrastructure.repository;

import br.com.algaworks.algafood.domain.model.Restaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> findNomeEFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        /* Modelo de consulta com JPQL
        var jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaInicial and :taxaFinal";
        return manager.createQuery(jpql, Restaurante.class).setParameter("nome", "%" + nome + "%")
                .setParameter("taxaInicial", taxaFreteInicial)
                .setParameter("taxaFinal", taxaFreteFinal)
                .getResultList();*/

        CriteriaBuilder builder = manager.getCriteriaBuilder(); //Funciona como uma fábrica para construir elementos, para construir consultas

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class); //CriteriaQuery precisa de uma instancia de CriteriaBuilder
        Root<Restaurante> root = criteria.from(Restaurante.class); //from Restaurante

        //Instanciação de predicados
        Predicate nomePredicate = builder.like(root.get("nome"),"%" + nome + "%");

        Predicate taxaInicialPredicate = builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);

        Predicate taxaFinalPredicate = builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);

        criteria.where(nomePredicate, taxaInicialPredicate, taxaFinalPredicate);

        TypedQuery<Restaurante> query = manager.createQuery(criteria); //createQuery tem uma sobrecarga que recebe um CriteriaQuery
        return  query.getResultList();
    }
}
