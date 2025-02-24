package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.UsuarioNaoEncontradoException;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CadastroUsuarioService {

    private UsuarioRepository usuarioRepository;
    private EntityManager entityManager; //Evitando a sincronização, tirando a instância para que ela pare de ser gerenciada pelo contexto de persistência (12.11)

    @Transactional
    public Usuario salvar(Usuario usuario) {
        entityManager.detach(usuario); //A JPA ira parar de gerenciar esse usuário e não haverá sincronização com BD

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail()); //Dentro do optional, ou está nulo, ou tem um usuário existente

        if(usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
        }

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        if(usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }

        usuario.setSenha(novaSenha);
    }

    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }
}
