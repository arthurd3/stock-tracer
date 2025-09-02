package com.arthur.stocktracer.exception;

public class FavoriteAlreadyExistsException extends RuntimeException {
    public FavoriteAlreadyExistsException(String symbol) {
        super("Symbol: " + symbol + " already exists");
    }
}
