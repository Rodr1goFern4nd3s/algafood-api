package com.algaworks.algafood.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValorZeroIncluiDescricaoValidator.class })
public @interface ValorZeroIncluiDescricao {

    //String message() default "{TaxaFrete.invalida}";
    String message() default "descrição obrigatória inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //Essas propriedades estão no parâmetro da anotação.
    String valorField();
    String descricaoField();
    String descricaoObrigatoria();
}
