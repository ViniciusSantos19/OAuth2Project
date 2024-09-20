package com.example.demo.shared;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ProjectException {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
