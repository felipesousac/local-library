package com.local.library.infra;

import com.local.library.infra.exception.AlreadyCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandling {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyCreatedException.class)
    public Map<String, String> handleAlreadyCreatedRecord(AlreadyCreatedException ex) {

        String genreId = Long.toString(ex.getGenreId());

        Map<String, String> map = new HashMap<>();
        map.put("error", ex.getMessage());
        map.put("genreId", genreId);

        return map;
    }
}
