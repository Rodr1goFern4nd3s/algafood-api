package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.ProdutoInputDesassembler;
import com.algaworks.algafood.api.assembler.ProdutoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.produto.ProdutoModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.produto.ProdutoModelOutput;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import com.algaworks.algafood.domain.service.CadastroProdutoService;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/produtos")
@AllArgsConstructor
public class RestauranteProdutoController {

    private CadastroRestauranteService cadastroRestauranteService;
    private CadastroProdutoService cadastroProdutoService;
    private ProdutoModelAssembler produtoModelAssembler;
    private ProdutoInputDesassembler produtoInputDesassembler;
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoModelOutput> listar(@PathVariable Long restauranteId, @RequestParam(required = false) boolean incluirInativos) {
        //Não esqueça de passar o parâmetro(incluirInativos com o value "true ou false") no Postman

        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        List<Produto> todosProdutos = null;

        if(incluirInativos) {
            todosProdutos = produtoRepository.findTodosByRestaurante(restaurante); //true
        } else {
            todosProdutos = produtoRepository.findAtivosByRestaurante(restaurante); //false
        }

        return produtoModelAssembler.toCollectionModel(todosProdutos);
    }

    @GetMapping("/{produtoId}")
    public ProdutoModelOutput buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProdutoService.buscarOuFalhar(restauranteId, produtoId);
        return produtoModelAssembler.toModel(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModelOutput adicionar(@PathVariable Long restauranteId, @RequestBody @Valid ProdutoModelInput produtoModelInput) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);
        Produto produto = produtoInputDesassembler.toDomainObject(produtoModelInput);
        produto.setRestaurante(restaurante);
        produto = cadastroProdutoService.salvar(produto);
        return produtoModelAssembler.toModel(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoModelOutput atualizar(@PathVariable Long restauranteId, @PathVariable Long produtoId, @RequestBody @Valid ProdutoModelInput produtoModelInput) {
        Produto produtoAtual = cadastroProdutoService.buscarOuFalhar(restauranteId, produtoId);
        produtoInputDesassembler.copyToDomainObject(produtoModelInput, produtoAtual);
        produtoAtual = cadastroProdutoService.salvar(produtoAtual);
        return produtoModelAssembler.toModel(produtoAtual);
    }
}
