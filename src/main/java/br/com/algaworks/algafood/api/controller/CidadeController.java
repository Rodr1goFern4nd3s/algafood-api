package br.com.algaworks.algafood.api.controller;

import br.com.algaworks.algafood.domain.model.Cidade;
import br.com.algaworks.algafood.domain.service.CadastroCidadeService;
import br.com.algaworks.algafood.infrastructure.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Cidade adicionar(@RequestBody Cidade cidade) {
        return cadastroCidade.salvar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> remover(@PathVariable Long id){
        Cidade cidade = repository.getReferenceById(id);

        if(cidade != null) {
            repository.delete(cidade);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
