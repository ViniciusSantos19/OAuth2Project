package com.example.demo.domain.exceptions;

public class NotFoundDomainException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NotFoundDomainException() {
        super();
    }
    public NotFoundDomainException(String message) {
        super(message);
    }
}
