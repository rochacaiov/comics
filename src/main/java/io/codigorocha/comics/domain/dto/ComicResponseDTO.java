package io.codigorocha.comics.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class ComicResponseDTO {

    @JsonIgnore
    private final Long userId;

    @JsonProperty(value = "comicId")
    private Long comicId;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "price")
    private double price;

    @JsonProperty(value = "authors")
    private String authors;

    @JsonProperty(value = "isbn")
    private String isbn;

    @JsonProperty(value = "description")
    private String description;
}
