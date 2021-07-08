package io.codigorocha.comics.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("Usuario com id %d nao encontrado.", id));
    }
}
