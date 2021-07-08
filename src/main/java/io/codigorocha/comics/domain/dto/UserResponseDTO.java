package io.codigorocha.comics.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserResponseDTO {
    private final Long id;
    private final String name;
    private final String birthDate;
    private final String email;
    private final String cpf;
    private final List<ComicResponseDTO> comics;
}
