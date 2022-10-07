package com.geniusee.cinema.service;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
