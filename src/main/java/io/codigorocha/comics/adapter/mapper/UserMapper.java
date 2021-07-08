package io.codigorocha.comics.adapter.mapper;

import io.codigorocha.comics.adapter.model.User;
import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;

public class UserMapper {

    public static UserResponseDTO from(User model) {
        return UserResponseDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .cpf(model.getCpf())
                .birthDate(model.getBirthDate())
                .comics(ComicMapper.from(model.getComics()))
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
