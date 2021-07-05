package io.codigorocha.comics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codigorocha.comics.adapter.mapper.UserMapper;
import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import io.codigorocha.comics.service.ComicService;
import io.codigorocha.comics.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@SpringBootTest
class ComicsApplicationTests {

    @Autowired
    private ComicService comicService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testServices() throws JsonProcessingException {
        final var createDTO = new ComicCreateDTO();
        final var user = userService.findUserById(1L);
        createDTO.setUser(user);
        createDTO.setUserId(1L);
        createDTO.setComicId(1158L);
        final var comic = this.comicService.create(createDTO);

        System.out.println(comic);
        //this.comicService.create()
    }

    @Test
    void newConsumer() throws JsonProcessingException {
        final var mapper = new ObjectMapper();
        ComicCreateDTO createDTO = new ComicCreateDTO();
        createDTO.setComicId(1158L);
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
        //JsonNode json = template.getForObject(uri.toString(), JsonNode.class);

        System.out.println(response.getBody().findValue("title"));


    }


    @Test
    void consumerAPI() throws IOException {    //comicId: 1158
//        final var timeStamp = "1";
//        final var apiKey = "ab5e6e81079373d55051686133897889";
//        final var hash = "03a64ef986afd80db6e8f6828d516ded";
//        final var uri = "https://gateway.marvel.com/v1/public/comics/1158?ts=1&apikey=ab5e6e81079373d55051686133897889&hash=03a64ef986afd80db6e8f6828d516ded";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        //ResponseEntity<DataList> responseEntity = restTemplate.getForObject(uri, DataList.class);
//        JsonNode data = restTemplate.getForObject(uri, JsonNode.class);
//        System.out.println(data.findValue("title"));
//        ComicResponseDTO responseEntity = restTemplate.getForObject(uri, ComicResponseDTO.class);
//        //DataList objects = responseEntity.getBody(); getData.findValue
//
//        ObjectMapper mapper = new ObjectMapper();

        //System.out.println(responseEntity.getData().findValue("title"));

//        JsonNode node = mapper.convertValue(responseEntity.getData().getResults(), JsonNode.class);
//        System.out.println(node.findValue("title"));
//
//        System.out.println(responseEntity.getData().getResults());


        //System.out.println(mapper.convertValue(objects, DataList.class).getData());

//        Arrays.stream(objects)
//                .map(object -> mapper.convertValue(object, Comic.class))
//                .map(Comic::getTitle)
//                .collect(Collectors.toList()).forEach(System.out::println);

//        ComicResponseWrapper response = restTemplate.exchange(
//                uri,
//                HttpMethod.GET,
//                entity,
//                ComicResponseWrapper.class
//        ).getBody();

//        ComicResponseWrapper comic = restTemplate.getForObject(uri, ComicResponseWrapper.class);
//        Object objects = restTemplate.getForObject(uri, Object.class);

        //Arrays.stream(comics).forEach(System.out::println);
//        System.out.println(comics.getTitle());
        //System.out.println(comic);
//        System.out.println(responseEntity);
//
//
//
//        //System.out.println(response);
//
//        System.out.println();
//        System.out.println(restTemplate.getForObject(uri, String.class));


//        String url = "https://gateway.marvel.com/v1/public/comics/1158?ts=1&apikey=ab5e6e81079373d55051686133897889&hash=03a64ef986afd80db6e8f6828d516ded";
//        RestTemplate restTemplate = new RestTemplate();
//
//        ComicResponseDTO comicResponseDTO = restTemplate.getForObject(url, ComicResponseDTO.class);
//
//        System.out.println(comicResponseDTO.getTitle());
        // https://gateway.marvel.com/v1/public/comics/1158?ts=1&apikey=ab5e6e81079373d55051686133897889&hash=03a64ef986afd80db6e8f6828d516ded
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .scheme("https")
//                .host("gateway.marvel.com")
//                .path("v1/public/comics/1158")
//                .queryParam("ts", 1)
//                .queryParam("apikey", "ab5e6e81079373d55051686133897889")
//                .queryParam("hash", "03a64ef986afd80db6e8f6828d516ded")
//                .build();
//
//        ResponseEntity<ComicResponseDTO> response = restTemplate.getForEntity(uriComponents.toUriString(), ComicResponseDTO.class);
//
//        System.out.println(response.getBody().getTitle());
    }


}
