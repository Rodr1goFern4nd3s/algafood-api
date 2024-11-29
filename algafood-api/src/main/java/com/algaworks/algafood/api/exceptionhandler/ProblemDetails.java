package com.algaworks.algafood.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ProblemDetails {

    /*@Builder
    O Builder do lombok, ajuda agente a instanciar um problema
    usando um padrão builder chamando nomeClasse.builder().title(passo o valor).status(passo o valor).build();
     */

    private Integer status;
    private String type;
    private String title;
    private String detail;

}
