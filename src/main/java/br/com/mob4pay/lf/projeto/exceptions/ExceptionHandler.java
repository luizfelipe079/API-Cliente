package br.com.mob4pay.lf.projeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
    protected ResponseEntity<Object> objectNotFound(ObjectNotFoundException e){
        String msg = "Objeto não encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
