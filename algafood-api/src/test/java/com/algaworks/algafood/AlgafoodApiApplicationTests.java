package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CadastroCozinhaIT {

	//Exemplo de testes de integração

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;

	@Test
	public void cadastroCozinhaComSucesso() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Holandesa");

		// ação
		novaCozinha = cadastroCozinhaService.salvar(novaCozinha);

		// validação

	}

	@Test()
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		/*EntidadeEmUsoException erroEsperado = Assertions.assertThrows(EntidadeEmUsoException.class, () -> {cadastroCozinhaService.excluir(1L); });
		assertThat(erroEsperado).isNotNull();*/
	}

	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {

	}
}
