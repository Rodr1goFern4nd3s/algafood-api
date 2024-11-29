package com.algaworks.algafood.api.exceptionhandler;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.ref.Reference;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(e);

        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        } else if (rootCause instanceof PropertyBindingException) {
            return handlePropertyBindingException((PropertyBindingException) rootCause, headers, status, request);
        }

        ProblemType problemType = ProblemType.MENSAGEM_IMCOMPREENSIVEL;
        String detail = "O corpo da requisição está inválido. Verifique erro de sintaxe.";

        ProblemDetails problemDetails = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(e, problemDetails, headers, status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String path = joinPath(e.getPath()).toString();

        ProblemType problemType = ProblemType.MENSAGEM_IMCOMPREENSIVEL;
        String detail = String.format("A propriedade '%s' recebeu o valor '%s', "
                        + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                path, e.getValue(), e.getTargetType().getSimpleName());

        ProblemDetails problemDetails = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(e, problemDetails, headers, status, request);
    }

    private Object joinPath(List<JsonMappingException.Reference> references) {
        return references.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;
        String detail = e.getMessage();

        ProblemDetails problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException e, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.ENTIDADE_EM_USO;
        String detail = e.getMessage();

        ProblemDetails problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException e,  WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.ERRO_NEGOCIO;
        String detail = e.getMessage();

        ProblemDetails problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
    }

    /*@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> tratatHttpMediaTypeNotSupportedException() {
        Problema problema = Problema.builder()
                .dataHora(LocalDateTime.now())
                .mensagem("O tipo de mídia não é aceito.").build();

        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(problema);
    }*/

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (body == null) {
            body = ProblemDetails.builder()
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        } else if (body instanceof String) {
            body = ProblemDetails.builder()
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ProblemDetails.ProblemDetailsBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {

        return ProblemDetails.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }

    private ResponseEntity<Object> handlePropertyBindingException(PropertyBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        // Criei o método joinPath para reaproveitar em todos os métodos que precisam
        // concatenar os nomes das propriedades (separando por ".")
        String path = (String) joinPath(ex.getPath());

        ProblemType problemType = ProblemType.MENSAGEM_IMCOMPREENSIVEL;
        String detail = String.format("A propriedade '%s' não existe. Corrija ou remova essa propriedade e tente novamente.", path);

        ProblemDetails problemDetails = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problemDetails, headers, status, request);
    }
}
