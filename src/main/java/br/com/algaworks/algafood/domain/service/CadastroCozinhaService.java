package br.com.algaworks.algafood.domain.service;

import br.com.algaworks.algafood.domain.model.Cozinha;
import br.com.algaworks.algafood.infrastructure.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }
}
