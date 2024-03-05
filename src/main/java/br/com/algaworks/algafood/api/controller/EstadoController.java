package br.com.algaworks.algafood.api.controller;

import br.com.algaworks.algafood.domain.model.Estado;
import br.com.algaworks.algafood.domain.service.CadastroEstadoService;
import br.com.algaworks.algafood.infrastructure.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return cadastroEstado.salvar(estado);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long id) {

    }*/

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Estado> remover(@PathVariable Long id) {
        Estado estado = repository.getReferenceById(id);

        if(estado != null) {
            repository.delete(estado);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
