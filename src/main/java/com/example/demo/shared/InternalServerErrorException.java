package com.example.demo.shared;

public class InternalServerErrorException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InternalServerErrorException(String message) {
    super(message);
  }

  public InternalServerErrorException(String message, Throwable cause) {
    super(message, cause);
  }


}
