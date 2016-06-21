package org.card.random.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6968158355615841142L;

    public ResourceNotFoundException(String suit) {
        super("could not find suit type '" + suit + "'.");
    }
}