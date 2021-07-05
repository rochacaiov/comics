package io.codigorocha.comics.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.codigorocha.comics.adapter.model.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ComicCreateDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long comicId;

    private String title;

    private double price;

    private String creators;

    private String isbn;

    private String description;

    private User user;

}
