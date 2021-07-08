package io.codigorocha.comics.adapter.controller;

import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;
import io.codigorocha.comics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") @NotBlank Long id) {
        final var searchedUser = userService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(searchedUser);
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserCreateDTO createDTO) {
        final var createdUser = userService.create(createDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }
}
