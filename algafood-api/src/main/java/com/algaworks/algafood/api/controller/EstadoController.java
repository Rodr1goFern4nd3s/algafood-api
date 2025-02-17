package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.EstadoInputDesassembler;
import com.algaworks.algafood.api.assembler.EstadoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.estado.EstadoModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.estado.EstadoModelOutput;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estados")
@AllArgsConstructor
public class EstadoController {

    private EstadoRepository estadoRepository;
    private CadastroEstadoService cadastroEstadoService;
    private EstadoModelAssembler estadoModelAssembler;
    private EstadoInputDesassembler estadoInputDesassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstadoModelOutput> listar() {
        return estadoModelAssembler.toCollectionModel(estadoRepository.findAll());
        //return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.OK)
    public EstadoModelOutput buscar(@PathVariable Long estadoId) {

        Estado estado = cadastroEstadoService.buscarOuFalhar(estadoId);
        return estadoModelAssembler.toModel(estado);

        /*Optional<Estado> estado = estadoRepository.findById(estadoId);

        if(estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }

        return ResponseEntity.notFound().build();*/
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoModelOutput adicionar(@RequestBody @Valid EstadoModelInput estadoModelInput) {
        Estado estado = estadoInputDesassembler.toDomainObject(estadoModelInput);
        return estadoModelAssembler.toModel(cadastroEstadoService.salvar(estado));
        //return cadastroEstadoService.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public EstadoModelOutput atualizar(@PathVariable Long estadoId, @RequestBody @Valid EstadoModelInput estadoModelInput) {

        Estado estadoAtual = cadastroEstadoService.buscarOuFalhar(estadoId);
        estadoInputDesassembler.copyToDomainObject(estadoModelInput, estadoAtual);
        return estadoModelAssembler.toModel(cadastroEstadoService.salvar(estadoAtual));

        /*BeanUtils.copyProperties(estado, estadoAtual, "id");

        return cadastroEstadoService.salvar(estadoAtual);*/

        /*Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);

        if(!estadoAtual.isEmpty()) {
            BeanUtils.copyProperties(estado, estadoAtual.get(), "id");

            Estado estadoSalvo = cadastroEstadoService.salvar(estadoAtual.get());
            return ResponseEntity.ok(estadoAtual.get());
        }

        return ResponseEntity.notFound().build();*/
    }

    /*@DeleteMapping("/{estadoId}")
    public ResponseEntity<Estado> remover(@PathVariable Long estadoId) {

        try{
            cadastroEstadoService.excluir(estadoId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }*/

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId) {
        cadastroEstadoService.excluir(estadoId);
    }
}
