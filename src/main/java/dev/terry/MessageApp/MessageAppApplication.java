package dev.terry.MessageApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.terry"})
@EntityScan(basePackages = {"dev.terry.entities"})
@EnableJpaRepositories(basePackages = {"dev.terry.repos"})
public class MessageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageAppApplication.class, args);
	}

}
