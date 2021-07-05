package io.codigorocha.comics.service;

import io.codigorocha.comics.adapter.mapper.UserMapper;
import io.codigorocha.comics.adapter.model.User;
import io.codigorocha.comics.adapter.repository.UserRepository;
import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;
import io.codigorocha.comics.domain.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserResponseDTO findById(Long id) {
        final var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.from(user);
    }

    public UserResponseDTO create(UserCreateDTO createDTO) {
        final var user = userRepository.save(UserMapper.to(createDTO));
        return UserMapper.from(user);
    }
}
