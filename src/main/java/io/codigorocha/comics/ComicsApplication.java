package io.codigorocha.comics;

import io.codigorocha.comics.domain.dto.ComicCreateDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//application (exclude = DataSourceAutoConfiguration.class)
//@EnableJpaRepositories(basePackages = "io.codigorocha.comics.adapter.model.repository")
//@EntityScan("io.codigorocha.comics.adapter.model.repository")
@SpringBootApplication
public class ComicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComicsApplication.class, args);

    }

}
