package io.codigorocha.comics.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ComicCreateDTO {
    @NotNull
    @JsonProperty(value = "userId")
    private Long userId;

    @NotNull
    @JsonProperty(value = "comicId")
    private Long comicId;

    private String title;

    private double price;

    private String creators;

    private String isbn;

    private String description;
}
