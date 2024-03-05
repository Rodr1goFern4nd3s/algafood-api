package br.com.algaworks.algafood.api.controller;

import br.com.algaworks.algafood.domain.model.Restaurante;
import br.com.algaworks.algafood.domain.service.CadastroRestauranteService;
import br.com.algaworks.algafood.infrastructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;
    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<Restaurante> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {

        Restaurante restaurante = repository.getReferenceById(id);
        if(restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        //Se cadastrar um restaurante e vincular uma cozinha que não existe dará uma exception!
        return cadastroRestaurante.salvar(restaurante);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id) {

    }*/
}
