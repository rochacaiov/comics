package io.codigorocha.comics.domain.exception;

public class ComicAlreadyRegisteredException extends RuntimeException {
    public ComicAlreadyRegisteredException() {
        super("Comic já registrada!");
    }
}
