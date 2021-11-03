package br.com.zup.exercicio2.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class) // anotação para capturar excecao
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception) {

        //forma mais elegante
        /* List<MensagemDeErro> mensagens = exception.getFieldErrors().stream().map(erro -> new
                MensagemDeErro(erro.getDefaultMessage())).collect(Collectors.toList()); */

        List<MensagemDeErro> mensagens = new ArrayList<>();

        for (FieldError fieldError: exception.getFieldErrors()) {
            mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage()));
        }
        return mensagens;
    }
}
