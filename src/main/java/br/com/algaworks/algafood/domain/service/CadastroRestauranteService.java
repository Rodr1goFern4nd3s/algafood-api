package br.com.algaworks.algafood.domain.service;

import br.com.algaworks.algafood.domain.model.Restaurante;
import br.com.algaworks.algafood.infrastructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante) {
        //Se cadastrar um restaurante e vincular uma cozinha que não existe dará uma exception!
        return restauranteRepository.save(restaurante);
    }
}
