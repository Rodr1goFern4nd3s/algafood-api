package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.PermissaoInputDesassembler;
import com.algaworks.algafood.api.assembler.PermissaoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.cozinha.CozinhaModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.permissao.PermissaoModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.cozinha.CozinhaModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.permissao.PermissaoModelOutput;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/permissoes")
@AllArgsConstructor
public class PermissaoController {

    private PermissaoRepository permissaoRepository;
    private CadastroPermissaoService cadastroPermissaoService;
    private PermissaoModelAssembler permissaoModelAssembler;
    private PermissaoInputDesassembler permissaoInputDesassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PermissaoModelOutput> listar() {
        List<Permissao> todasPermissoes = permissaoRepository.findAll();
        return permissaoModelAssembler.toCollectionModel(todasPermissoes);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PermissaoModelOutput adicionar(@RequestBody @Valid PermissaoModelInput permissaoModelInput) {
        Permissao permissao = permissaoInputDesassembler.toDomainObject(permissaoModelInput);
        permissao = cadastroPermissaoService.salvar(permissao);
        return permissaoModelAssembler.toModel(permissao);
    }

    @PutMapping("/{permissaoId}")
    public PermissaoModelOutput atualizar(@PathVariable Long permissaoId, @RequestBody @Valid PermissaoModelInput permissaoModelInput) {

        Permissao permissaoAtual = cadastroPermissaoService.buscarOuFalhar(permissaoId);

        permissaoInputDesassembler.copyToDomainObject(permissaoModelInput, permissaoAtual);

        return permissaoModelAssembler.toModel(cadastroPermissaoService.salvar(permissaoAtual));
    }

    @DeleteMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long permissaoId) {
        cadastroPermissaoService.excluir(permissaoId);
    }
}
