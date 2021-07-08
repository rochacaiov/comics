package io.codigorocha.comics.adapter.controller;

import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.ComicResponseDTO;
import io.codigorocha.comics.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<ComicResponseDTO> create(@Valid @RequestBody ComicCreateDTO createDTO) {
        final var createdComic = comicService.create(createDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdComic);
    }
}
