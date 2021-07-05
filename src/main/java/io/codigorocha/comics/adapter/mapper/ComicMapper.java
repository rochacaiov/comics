package io.codigorocha.comics.adapter.mapper;

import io.codigorocha.comics.adapter.model.Comic;
import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.ComicResponseDTO;

import java.util.List;

public class ComicMapper {

    public static ComicResponseDTO from(Comic model) {
        return ComicResponseDTO.builder()
                .comicId(model.getComicId())
                .title(model.getTitle())
                .price(model.getPrice())
                .authors(model.getAuthors())
                .isbn(model.getIsbn())
                .description(model.getDescription())
                .build();
    }

    public static Comic to(ComicCreateDTO createDTO) {
        return Comic.builder()
                .id(createDTO.getUserId())
                .comicId(createDTO.getComicId())
                .title(createDTO.getTitle())
                .price(createDTO.getPrice())
                .authors(createDTO.getCreators())
                .isbn(createDTO.getIsbn())
                .description(createDTO.getDescription())
                .users(List.of(createDTO.getUser()))
                .build();
    }

}
