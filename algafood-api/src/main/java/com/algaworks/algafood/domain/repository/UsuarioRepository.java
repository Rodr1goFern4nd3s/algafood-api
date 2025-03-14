package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email); //Query Methods - Regra de negócio para evitar emails duplicados
}
