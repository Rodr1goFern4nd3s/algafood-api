package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.GrupoInputDesassembler;
import com.algaworks.algafood.api.assembler.GrupoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.grupo.GrupoModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.grupo.GrupoModelOutput;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import com.algaworks.algafood.domain.service.CadastroGrupoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
@AllArgsConstructor
public class GrupoController {

    private GrupoRepository grupoRepository;
    private CadastroGrupoService cadastroGrupoService;
    private GrupoModelAssembler grupoModelAssembler;
    private GrupoInputDesassembler grupoInputDesassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GrupoModelOutput> listar() {
        return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
    }

    @GetMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.OK)
    public GrupoModelOutput buscar(@PathVariable Long grupoId) {
        Grupo grupo = cadastroGrupoService.buscarOuFalhar(grupoId);
        return grupoModelAssembler.toModel(grupo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoModelOutput adicionar(@RequestBody @Valid GrupoModelInput grupoModelInput) {
        Grupo grupo = grupoInputDesassembler.toDomainObject(grupoModelInput);
        return grupoModelAssembler.toModel(cadastroGrupoService.salvar(grupo));
    }

    @PutMapping("/{grupoId}")
    public GrupoModelOutput atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoModelInput grupoModelInput) {
        Grupo grupoAtual = cadastroGrupoService.buscarOuFalhar(grupoId);
        grupoInputDesassembler.copyToDomainObject(grupoModelInput, grupoAtual);
        return grupoModelAssembler.toModel(cadastroGrupoService.salvar(grupoAtual));
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long grupoId) {
        cadastroGrupoService.excluir(grupoId);
    }
}
