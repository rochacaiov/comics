package io.codigorocha.comics.adapter.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        StringBuilder builder = new StringBuilder();
        List<FieldError> errors = exception.getFieldErrors();
        for (FieldError error : errors) {
            builder.append(error.getField() + " : " + error.getDefaultMessage());
        }
        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder().message(builder.toString()).build());
    }

    @Builder
    @Getter
    static class ErrorMessage {
        private final String message;
    }
}
