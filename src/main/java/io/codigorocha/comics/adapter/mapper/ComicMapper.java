package io.codigorocha.comics.adapter.mapper;

import io.codigorocha.comics.adapter.model.Comic;
import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.ComicResponseDTO;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ValueRange;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComicMapper {

    public static ComicResponseDTO from(Comic model) {
        final var isSaleDay = isSaleDay(model.getIsbn());
        final var builder = ComicResponseDTO.builder()
                .id(model.getComicId())
                .title(model.getTitle())
                .price(model.getPrice())
                .creators(model.getCreators())
                .isbn(model.getIsbn())
                .description(model.getDescription())
                .saleDay(getDaySale(model.getIsbn()))
                .saleActive(isSaleDay);

        if (isSaleDay) {
            builder.price(model.getPrice() - (model.getPrice() * 10) / 100);
        }

        return builder.build();
    }

    public static List<ComicResponseDTO> from(List<Comic> models) {
        if (Objects.isNull(models) || models.isEmpty()) {
            return Collections.emptyList();
        }

        return models.stream()
                .map(ComicMapper::from)
                .collect(Collectors.toList());
    }

    public static Comic to(ComicCreateDTO model) {
        return Comic.builder()
                .comicId(model.getComicId())
                .title(model.getTitle())
                .price(model.getPrice())
                .creators(model.getCreators())
                .isbn(model.getIsbn())
                .description(model.getDescription())
                .build();
    }

    private static DayOfWeek getDaySale(String isbn) {
        final var lastNumberIsbn = Integer.parseInt(isbn.substring(isbn.length() - 1));
        if (ValueRange.of(0, 1).isValidValue(lastNumberIsbn)) return DayOfWeek.MONDAY;
        if (ValueRange.of(2, 3).isValidValue(lastNumberIsbn)) return DayOfWeek.TUESDAY;
        if (ValueRange.of(4, 5).isValidValue(lastNumberIsbn)) return DayOfWeek.WEDNESDAY;
        if (ValueRange.of(6, 7).isValidValue(lastNumberIsbn)) return DayOfWeek.THURSDAY;
        return DayOfWeek.FRIDAY;
    }

    private static boolean isSaleDay(String isbn) {
        LocalDateTime localDate = LocalDateTime.now();
        return localDate.getDayOfWeek().equals(getDaySale(isbn));
    }
}
