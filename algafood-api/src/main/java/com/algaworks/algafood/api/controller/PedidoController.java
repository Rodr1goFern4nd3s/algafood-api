package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.PedidoInputDesassembler;
import com.algaworks.algafood.api.assembler.PedidoModelAssembler;
import com.algaworks.algafood.api.assembler.PedidoResumoModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.input.formaPagamento.FormaPagamentoModelInput;
import com.algaworks.algafood.api.representationModelDTO.input.pedido.PedidoInput;
import com.algaworks.algafood.api.representationModelDTO.input.restaurante.RestauranteModelInput;
import com.algaworks.algafood.api.representationModelDTO.output.pedido.PedidoModelOutput;
import com.algaworks.algafood.api.representationModelDTO.output.pedido.PedidoResumoModelOutput;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.PedidoRepository;
import com.algaworks.algafood.domain.service.EmissaoPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoRepository pedidoRepository;
    private EmissaoPedidoService emissaoPedidoService;
    private PedidoModelAssembler pedidoModelAssembler;
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;
    private PedidoInputDesassembler pedidoInputDesassembler;


    @GetMapping
    public List<PedidoResumoModelOutput> listar() {
        List<Pedido> todosPedidos = pedidoRepository.findAll();

        return pedidoResumoModelAssembler.toCollectionModel(todosPedidos);
    }

    @GetMapping("/{pedidoId}")
    public PedidoModelOutput buscar(@PathVariable Long pedidoId) {
        Pedido pedido = emissaoPedidoService.buscarOuFalhar(pedidoId);

        return pedidoModelAssembler.toModel(pedido);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoModelOutput adicionar(@RequestBody @Valid PedidoInput pedidoInput) {
        try{
            Pedido novoPedido = pedidoInputDesassembler.toDomainObject(pedidoInput);

            // TODO pegar usuário autenticado
            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);

            novoPedido = emissaoPedidoService.emitir(novoPedido);
            return pedidoModelAssembler.toModel(novoPedido);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
}
