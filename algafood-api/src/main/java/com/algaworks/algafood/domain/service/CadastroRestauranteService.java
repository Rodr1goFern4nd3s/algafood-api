package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CadastroRestauranteService {

    //private static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com código %d";
    private static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removido, pois está em uso";

    private RestauranteRepository restauranteRepository;
    //private CozinhaRepository cozinhaRepository;
    private CadastroCozinhaService cadastroCozinhaService;

    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cadastroCozinhaService.buscarOuFalhar(cozinhaId);
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);

        //Ao cadastrar um restaurante, precisamos ver se a cozinha existe
        /*Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);*/
    }

    @Transactional
    public void excluir(Long restauranteId) {
        try {
            restauranteRepository.existsById(restauranteId);
        } catch (EmptyResultDataAccessException e) {
            throw new RestauranteNaoEncontradoException(restauranteId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_RESTAURANTE_EM_USO, restauranteId));
        }
    }

    @Transactional
    public void ativar(Long restauranteId) {
        Restaurante restauranteAtual = buscarOuFalhar(restauranteId);

        //restauranteAtual.setAtivo(true);
        restauranteAtual.ativar(); //Melhora a redação do código

        //Aqui depois, não preciso chamar o método restauranteRepository.save(restauranteAtual);
        /*
        Quando buscarOuFalhar pega no repo e retorna para nós, a instância do restaurante fica num estado gerenciado pelo contexto
        de persistência do JPA, qualquer modificação feita em restauranteAtual, ela será sincronizada(update lá na table) depois com o BD.
         */
    }

    @Transactional
    public void inativar(Long restauranteId) {
        Restaurante restauranteAtual = buscarOuFalhar(restauranteId);
        //restauranteAtual.setAtivo(false);
        restauranteAtual.inativar();
    }

    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId).orElseThrow(() ->
                new RestauranteNaoEncontradoException(restauranteId));
    }
}
