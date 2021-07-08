package io.codigorocha.comics.adapter.repository;

import io.codigorocha.comics.adapter.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {
    boolean existsComicByComicId(Long comicId);
}
