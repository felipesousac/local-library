package com.local.library.infra;

import com.local.library.infra.exception.AlreadyCreatedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(AlreadyCreatedException.class)
    public ResponseEntity handleAlreadyCreated() {
        return ResponseEntity.badRequest().body(new AlreadyCreatedException("There is already a record with that name").getMessage());
    }
}
