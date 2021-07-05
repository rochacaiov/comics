package io.codigorocha.comics.adapter.controller;

import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("comics")
public class ComicController {

//    @GetMapping(value = "/{id}/comics", produces = {APPLICATION_JSON_VALUE})
//    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") @NotBlank Long id) {
//        System.out.println("COMIC CONTROLLER REQUISITADO  =  " + id);
//        return null;
//    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody ComicCreateDTO createDTO) {
//        final var createdUser = userService.create(createDTO);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(createdUser);
        return null;
    }

}
