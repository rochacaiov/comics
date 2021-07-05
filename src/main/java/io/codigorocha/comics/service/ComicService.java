package io.codigorocha.comics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codigorocha.comics.adapter.mapper.ComicMapper;
import io.codigorocha.comics.adapter.repository.ComicRepository;
import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.domain.dto.ComicResponseDTO;
import io.codigorocha.comics.domain.exception.ComicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ComicService {
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ComicRepository comicRepository;

    public ComicResponseDTO create(ComicCreateDTO createDTO) throws JsonProcessingException {
        final var host = "gateway.marvel.com";
        final var timeStamp = "1";
        final var apiKey = "ab5e6e81079373d55051686133897889";
        final var hash = "03a64ef986afd80db6e8f6828d516ded";
        final var comicId = createDTO.getComicId();

        final var template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host)
                .path("v1/public/comics/" + comicId)
                .queryParam("ts", timeStamp)
                .queryParam("apikey", apiKey)
                .queryParam("hash", hash)
                .build();

        ResponseEntity<JsonNode> response = template.getForEntity(uri.toString(), JsonNode.class);

        if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)) throw new ComicNotFoundException();

        if(response.getBody() == null ) throw new ComicNotFoundException();

        String creatorsSerialized = mapper.writeValueAsString(
                response.getBody().findPath("creators").findPath("items").findValues("name")
        );

        createDTO.setTitle(response.getBody().findValue("title").asText());
        createDTO.setPrice(response.getBody().findValue("price").asDouble());
        createDTO.setCreators(creatorsSerialized);
        createDTO.setIsbn(response.getBody().findValue("isbn").asText());
        createDTO.setDescription(response.getBody().findValue("description").asText());

        final var comic = this.comicRepository.save(ComicMapper.to(createDTO));
        return ComicMapper.from(comic);


//        System.out.println(response.getBody().findPath("creators").findPath("items").findValues("name"));
//        System.out.println(createDTO);

//        createDTO.setTitle(response.getBody().getTitle());
//        createDTO.setPrice(response.getBody().getPrice());
//        createDTO.setAuthors(response.getBody().getAuthors());
//        createDTO.setIsbn(response.getBody().getIsbn());
//        createDTO.setDescription(response.getBody().getDescription());


        //this.comicRepository.save(ComicMapper.to(createDTO));
    }

}
