package io.codigorocha.comics.adapter.mapper;

import io.codigorocha.comics.adapter.model.User;
import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;

public class UserMapper {

    public static UserResponseDTO from(User model) {
        return UserResponseDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .cpf(model.getCpf())
                .birthDate(model.getBirthDate())
                .email(model.getEmail())
                .build();
    }

    public static User to(UserResponseDTO responseDTO) {
        return User.builder()
                .name(responseDTO.getName())
                .email(responseDTO.getEmail())
                .cpf(responseDTO.getCpf())
                .birthDate(responseDTO.getBirthDate())
                .build();
    }

    public static User to(UserCreateDTO createDTO) {
        return User.builder()
                .name(createDTO.getName())
                .email(createDTO.getEmail())
                .cpf(createDTO.getCpf())
                .birthDate(createDTO.getBirthdate())
                .build();
    }
}
