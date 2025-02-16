package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.GrupoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.output.grupo.GrupoModelOutput;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import com.algaworks.algafood.domain.service.CadastroGrupoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
@AllArgsConstructor
public class GrupoController {

    private GrupoRepository grupoRepository;
    private CadastroGrupoService cadastroGrupoService;
    private GrupoModelAssembler grupoModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GrupoModelOutput> listar() {
        return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
    }

    @GetMapping("/{grupoId}")
    public GrupoModelOutput buscar(@PathVariable Long grupoId) {

        Grupo grupo = cadastroGrupoService.buscarOuFalhar(grupoId);
        return grupoModelAssembler.toModel(grupo);
    }
}
