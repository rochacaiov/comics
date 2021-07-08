package io.codigorocha.comics.domain.exception;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists() {
        super("Usuário já cadastrado!");
    }
}
