package com.local.library.infra.exception;

public class AlreadyCreatedException extends Exception {
    public AlreadyCreatedException(String errorMesage) {
        super(errorMesage);
    }
}
