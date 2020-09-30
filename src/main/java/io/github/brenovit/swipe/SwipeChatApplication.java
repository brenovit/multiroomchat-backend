package io.github.brenovit.swipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class SwipeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwipeChatApplication.class, args);
	}
}
