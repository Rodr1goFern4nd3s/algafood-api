package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CidadeInputDesassembler;
import com.algaworks.algafood.api.assembler.CidadeModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.cidade.CidadeModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.cidade.CidadeModelOutput;
import com.algaworks.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cidades")
@AllArgsConstructor
public class CidadeController {

    private CadastroCidadeService cadastroCidadeService;
    private CidadeRepository cidadeRepository;
    private CidadeModelAssembler cidadeModelAssembler;
    private CidadeInputDesassembler cidadeInputDesassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CidadeModelOutput> listar() {
        return cidadeModelAssembler.toCollectionModel(cidadeRepository.findAll());
        // return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public CidadeModelOutput buscar(@PathVariable Long cidadeId) {

        Cidade cidade = cadastroCidadeService.buscarOuFalhar(cidadeId);
        return cidadeModelAssembler.toModel(cidade);

        // return cadastroCidadeService.buscarOuFalhar(cidadeId);

        /*Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);

        if(cidade.isPresent()) {
            return ResponseEntity.ok(cidade.get());
        }

        return ResponseEntity.notFound().build();*/
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModelOutput adicionar(@RequestBody @Valid CidadeModelInput cidadeModelnput) {

        try {
            Cidade cidade = cidadeInputDesassembler.toDomainObject(cidadeModelnput);
            return cidadeModelAssembler.toModel(cadastroCidadeService.salvar(cidade));
        } catch (CidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

        /*try {
            return cadastroCidadeService.salvar(cidade);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }*/
        /*try{
            cidade = cadastroCidadeService.salvar(cidade);

            return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
    }

    @PutMapping("/{cidadeId}")
    public CidadeModelOutput atualizar(@PathVariable Long cidadeId, @RequestBody @Valid CidadeModelInput cidadeModelInput) {

        try {
            Cidade cidadeAtual = cadastroCidadeService.buscarOuFalhar(cidadeId);

            cidadeInputDesassembler.copyToDomainObject(cidadeModelInput, cidadeAtual);

            return cidadeModelAssembler.toModel(cadastroCidadeService.salvar(cidadeAtual));
            //return cadastroCidadeService.salvar(cidadeAtual);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }

        /*try {
            Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);

            if (!cidadeAtual.isEmpty()) {
                BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");

                Cidade cidadeSalva = cadastroCidadeService.salvar(cidadeAtual.get());
                return ResponseEntity.ok(cidadeSalva);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }*/
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {

        cadastroCidadeService.excluir(cidadeId);

        /*try {
            cadastroCidadeService.excluir(cidadeId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }*/
    }
}
