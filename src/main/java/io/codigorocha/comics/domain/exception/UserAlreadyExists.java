package io.codigorocha.comics.domain.exception;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists() {
        super("USUÁRIO COM CPF/EMAIL JÁ CADASTRADOS NO SISTEMA");
    }

}
