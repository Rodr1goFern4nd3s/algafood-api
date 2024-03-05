package br.com.algaworks.algafood.domain.service;

import br.com.algaworks.algafood.domain.model.Cidade;
import br.com.algaworks.algafood.infrastructure.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository repository;

    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }
}
