package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.representationModelDTO.output.usuario.UsuarioModelOutput;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/responsaveis")
@AllArgsConstructor
public class RestauranteUsuarioResponsavelController {

    //Aqui determinamos os usuários que são gerentes e/ou donos(responsáveis) pelo restaurante

    private UsuarioModelAssembler usuarioModelAssembler;
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<UsuarioModelOutput> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        return usuarioModelAssembler.toCollectionModel(restaurante.getResponsaveis());
    }

    @PutMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long usuarioId, @PathVariable Long restauranteId) {
        cadastroRestauranteService.associarResponsavel(usuarioId, restauranteId);
    }
}
