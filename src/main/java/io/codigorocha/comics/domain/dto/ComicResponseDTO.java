package io.codigorocha.comics.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ComicResponseDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "price")
    private Double price;

    @JsonProperty(value = "creators")
    private String creators;

    @JsonProperty(value = "isbn")
    private String isbn;

    @JsonProperty(value = "description")
    private String description;

    private DayOfWeek saleDay;

    private boolean saleActive;
}
