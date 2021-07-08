package io.codigorocha.comics.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.codigorocha.comics.adapter.mapper.ComicMapper;
import io.codigorocha.comics.adapter.repository.ComicRepository;
import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.ComicResponseDTO;
import io.codigorocha.comics.domain.exception.ComicAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private UserService userService;

    public ComicResponseDTO create(ComicCreateDTO createDTO) {
        final var comicId = createDTO.getComicId();
        final var userId = createDTO.getUserId();

        if (existsComicByComicId(comicId)) throw new ComicAlreadyRegisteredException();

        final var responseDTO = requestComicMarvelAPI(comicId);

        createDTO.setTitle(responseDTO.getTitle());
        createDTO.setPrice(responseDTO.getPrice());
        createDTO.setCreators(responseDTO.getCreators());
        createDTO.setIsbn(responseDTO.getIsbn());
        createDTO.setDescription(responseDTO.getDescription());

        final var comicEntity = ComicMapper.to(createDTO);
        comicEntity.setUser(userService.findUserById(userId));

        return ComicMapper.from(comicRepository.save(comicEntity));
    }

    private ComicResponseDTO requestComicMarvelAPI(Long comicId) {
        final var host = "gateway.marvel.com";
        final var timeStamp = "1";
        final var apiKey = "ab5e6e81079373d55051686133897889";
        final var hash = "03a64ef986afd80db6e8f6828d516ded";
        final var template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host)
                .path("v1/public/comics/" + comicId)
                .queryParam("ts", timeStamp)
                .queryParam("apikey", apiKey)
                .queryParam("hash", hash)
                .build();

        ResponseEntity<JsonNode> responseNode = template.getForEntity(uri.toString(), JsonNode.class);

        return ComicResponseDTO.builder()
                .id(comicId)
                .title(responseNode.getBody().findValue("title").asText())
                .price(responseNode.getBody().findValue("price").asDouble())
                .creators(responseNode.getBody().findPath("creators").findPath("items").findValues("name").toString())
                .isbn(responseNode.getBody().findValue("isbn").asText())
                .description(responseNode.getBody().findValue("description").asText())
                .build();
    }

    public boolean existsComicByComicId(Long id) {
        return comicRepository.existsComicByComicId(id);
    }
}
