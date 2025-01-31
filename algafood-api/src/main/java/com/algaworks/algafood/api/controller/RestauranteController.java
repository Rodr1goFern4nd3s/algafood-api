package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.RestauranteInputDesassembler;
import com.algaworks.algafood.api.assembler.RestauranteModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.restaurante.RestauranteModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.restaurante.RestauranteModelOutput;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
@AllArgsConstructor
public class RestauranteController {

    private CadastroRestauranteService cadastroRestauranteService;
    private RestauranteRepository restauranteRepository;
    private RestauranteModelAssembler restauranteModelAssembler;
    private RestauranteInputDesassembler restauranteInputDesassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RestauranteModelOutput> listar() {
        return restauranteModelAssembler.toCollectionModel(restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteModelOutput buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        return restauranteModelAssembler.toModel(restaurante);

        /*Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);

        if(restaurante.isPresent()) {
            return ResponseEntity.ok(restaurante.get());
        }

        return ResponseEntity.notFound().build();
        /*
        Busca o restaurante e atribui a um tipo Restaurante

        Se Restaurante != null devolve ResponseEntity.Ok
        Senão NotFound
         */
    }

    @GetMapping("/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNome(nome, cozinhaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteModelOutput adicionar(@RequestBody @Valid RestauranteModelInput restauranteModelInput) {
        try {
            Restaurante restaurante = restauranteInputDesassembler.toDomainObject(restauranteModelInput);
            return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restaurante));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public RestauranteModelOutput atualizar(@PathVariable Long restauranteId, @RequestBody @Valid RestauranteModelInput restauranteModelInput) {

        try {
            //Restaurante restaurante = restauranteInputDesassembler.toDomainObject(restauranteModelInput);

            Restaurante restauranteAtual = cadastroRestauranteService.buscarOuFalhar(restauranteId);

            restauranteInputDesassembler.copyToDomainObject(restauranteModelInput, restauranteAtual);

            /*Este procedimento sendo feito na linha acima!
            BeanUtils.copyProperties(restaurante, restauranteAtual,
                    "id", "formasPagamento", "endereco", "dataCadastro", "produtos");*/

            return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restauranteAtual));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }

        /*Restaurante restauranteAtual = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

        try {
            return cadastroRestauranteService.salvar(restauranteAtual);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }*/

        /*try{
            Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

            if(restauranteAtual.isPresent()) {
                BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id", "endereco", "dataCadastro", "produtos ");

                Restaurante restauranteSalvo = cadastroRestauranteService.salvar(restauranteAtual.get());
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
    }

    @DeleteMapping("/{restauranteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long restauranteId) {
        cadastroRestauranteService.excluir(restauranteId);

        /*try {
            cadastroRestauranteService.excluir(restauranteId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }*/
    }
}
