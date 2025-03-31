package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CozinhaInputDesassembler;
import com.algaworks.algafood.api.assembler.CozinhaModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.cozinha.CozinhaModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.cozinha.CozinhaModelOutput;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    private CozinhaRepository cozinhaRepository;
    private CadastroCozinhaService cadastroCozinhaService;
    private CozinhaModelAssembler cozinhaModelAssembler;
    private CozinhaInputDesassembler cozinhaInputDesassembler;

    /*@GetMapping
    public List<CozinhaModelOutput> listar() {
        List<Cozinha> todasCozinhas = cozinhaRepository.findAll();
        return cozinhaModelAssembler.toCollectionModel(todasCozinhas);
        //return cozinhaRepository.findAll();
    }*/

    //Exemplo de um listar com paginação
    @GetMapping
    public Page<CozinhaModelOutput> listar(Pageable pageable) {
        Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);

        List<CozinhaModelOutput> cozinhasModelOutput = cozinhaModelAssembler.toCollectionModel(cozinhasPage.getContent());

        Page<CozinhaModelOutput> cozinhasModelPage = new PageImpl<>(cozinhasModelOutput, pageable, cozinhasPage.getTotalElements());
        return cozinhasModelPage;
    }

    @GetMapping("/{cozinhaId}")
    public CozinhaModelOutput buscar(@PathVariable Long cozinhaId) {
        Cozinha cozinha = cadastroCozinhaService.buscarOuFalhar(cozinhaId);
        return cozinhaModelAssembler.toModel(cozinha);

        //return cadastroCozinhaService.buscarOuFalhar(cozinhaId);

        /*Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);

        if(cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
        }

        return ResponseEntity.notFound().build();*/
    }

    @GetMapping("/unica-por-nome")
    public CozinhaModelOutput buscarPorNomeExato(String nomeCozinha) {
        Optional<Cozinha> cozinha = cozinhaRepository.findPesquisaExataByNome(nomeCozinha);
        return cozinhaModelAssembler.toModel(cozinha.get());

        //return cozinhaRepository.findPesquisaExataByNome(nomeCozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaModelOutput adicionar(@RequestBody @Valid CozinhaModelInput cozinhaModelInput) {

        Cozinha cozinha = cozinhaInputDesassembler.toDomainObject(cozinhaModelInput);
        return cozinhaModelAssembler.toModel(cadastroCozinhaService.salvar(cozinha));
        //return cadastroCozinhaService.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public CozinhaModelOutput atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid CozinhaModelInput cozinhaModelInput) {

            Cozinha cozinhaAtual = cadastroCozinhaService.buscarOuFalhar(cozinhaId);

            cozinhaInputDesassembler.copyToDomainObject(cozinhaModelInput, cozinhaAtual);

            return cozinhaModelAssembler.toModel(cadastroCozinhaService.salvar(cozinhaAtual));

        /*Cozinha cozinhaAtual = cadastroCozinhaService.buscarOuFalhar(cozinhaId);

        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); //Quando vai atualizar ele vai pegar os novos dados(cozinha) e copiar pra instancia(cozinhaAtual)

        return cadastroCozinhaService.salvar(cozinhaAtual);*/
    }

    /*@DeleteMapping("/{cozinhaId}")
    public ResponseEntity<?> remover(@PathVariable Long cozinhaId) {
        try {
            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }*/

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinhaService.excluir(cozinhaId);
    }
}
