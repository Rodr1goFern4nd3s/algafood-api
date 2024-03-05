package br.com.algaworks.algafood.domain.service;

import br.com.algaworks.algafood.domain.model.Estado;
import br.com.algaworks.algafood.infrastructure.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }
}
