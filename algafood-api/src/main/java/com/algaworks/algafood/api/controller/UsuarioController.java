package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.UsuarioInputDesassembler;
import com.algaworks.algafood.api.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.usuario.SenhaInput;
import com.algaworks.algafood.api.representationModelDTO.input.usuario.UsuarioComSenhaInput;
import com.algaworks.algafood.api.representationModelDTO.input.usuario.UsuarioModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.usuario.UsuarioModelOutput;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import com.algaworks.algafood.domain.service.CadastroUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private CadastroUsuarioService cadastroUsuarioService;
    private UsuarioModelAssembler usuarioModelAssembler;
    private UsuarioInputDesassembler usuarioInputDesassembler;

    @GetMapping
    public List<UsuarioModelOutput> listar() {
        List<Usuario> todosUsuarios = usuarioRepository.findAll();
        return usuarioModelAssembler.toCollectionModel(todosUsuarios);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModelOutput buscar(@PathVariable Long usuarioId) {

        Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);
        return usuarioModelAssembler.toModel(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModelOutput adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioComSenhaInput) {
        Usuario usuario = usuarioInputDesassembler.toDomainObject(usuarioComSenhaInput);
        usuario = cadastroUsuarioService.salvar(usuario);
        return usuarioModelAssembler.toModel(usuario);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioModelOutput atualizar(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioModelInput usuarioModelInput) {
        Usuario usuarioAtual = cadastroUsuarioService.buscarOuFalhar(usuarioId);
        usuarioInputDesassembler.copyToDomainObject(usuarioModelInput, usuarioAtual);
        usuarioAtual = cadastroUsuarioService.salvar(usuarioAtual);
        return usuarioModelAssembler.toModel(usuarioAtual);
    }

    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInput senhaInput) {
        cadastroUsuarioService.alterarSenha(usuarioId, senhaInput.getSenhaAtual(), senhaInput.getNovaSenha());
    }
}
