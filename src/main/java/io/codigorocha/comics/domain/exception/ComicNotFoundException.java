package io.codigorocha.comics.domain.exception;

public class ComicNotFoundException extends RuntimeException{
    public ComicNotFoundException() {
        super("Comic não encontrada!");
    }
}
