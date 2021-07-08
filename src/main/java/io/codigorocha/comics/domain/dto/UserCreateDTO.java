package io.codigorocha.comics.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Data
public class UserCreateDTO {
    @NotNull
    private final String name;

    @NotNull
    @Email
    private final String email;

    @NotNull
    @Pattern(
            regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|" +
                    "([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})",
            message = "CPF invalido."
    )
    private final String cpf;

    @NotNull
    private final String birthdate;
}
