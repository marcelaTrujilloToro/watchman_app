package com.umanizales.watchman_app.infrastructure.controllers;

import com.umanizales.watchman_app.exception.WatchmanAppException;
import com.umanizales.watchman_app.infrastructure.controllers.dto.ErrorDTO;
import com.umanizales.watchman_app.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandlerController {
    //metodos por cada una de las excepciones que quiero que este me transforme
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handle(MethodArgumentNotValidException ex){
        List<ErrorDTO> listErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), fieldName +" "+ errorMessage));
        });
        String message = "Algunos campos son inválidos o faltantes, por favor corrija los errores y vuelva a intentarlo";
        ResponseDTO response = new ResponseDTO( message,null , listErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //excepcion de logica de negocio para que avise cuando se envia un codigo que no existe
    @ExceptionHandler(WatchmanAppException.class)
    protected ResponseEntity<?>handle(WatchmanAppException ex){
        //transformar el mesaje por una respuesta para el cliente con un codigo http
        ResponseDTO  response = new ResponseDTO(ex.getMessage(),null,null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

