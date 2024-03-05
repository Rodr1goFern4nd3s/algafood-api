package br.com.algaworks.algafood.api.controller;

import br.com.algaworks.algafood.domain.model.Cozinha;
import br.com.algaworks.algafood.domain.service.CadastroCozinhaService;
import br.com.algaworks.algafood.infrastructure.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository repository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping
    public List<Cozinha> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id){

        Cozinha cozinha = repository.getReferenceById(id);

        if(cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
        Cozinha cozinha = repository.getReferenceById(id);
        System.out.println("Cozinha: " + cozinha);
        if(cozinha != null) {
            repository.delete(cozinha);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
